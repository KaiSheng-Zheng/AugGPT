package com.auggpt.service;

import com.auggpt.model.Agent;
import com.auggpt.model.AgentType;
import com.auggpt.model.ChatGPTAgent;
import com.auggpt.model.ChatGPTAgentRaw;
import dev.langchain4j.data.message.ChatMessage;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

/**
 * <p> This class provides a convenient container and some methods to initialize, close and chat with multiple agents.
 */
@Slf4j
public class MultiAgentManager {
    private final static MultiAgentManager MULTI_AGENT_SERVICE = new MultiAgentManager();
    private MultiAgentManager(){}
    public static MultiAgentManager getInstance(){
        return MULTI_AGENT_SERVICE;
    }
    private final HashMap<String, Agent> agents = new HashMap<>();

    /**
     * Create and initialize an agent, then put into the map.
     * @param name
     * @param agentType
     * @param api
     */
    public boolean putAgent(String name, AgentType agentType, String api){
        if (agentType==null){
            log.error("Trying to put a null agent!");
            return false;
        }
        if(1000<=agentType.getCode() && agentType.getCode()<1100){
            Agent agent = new ChatGPTAgent(api);
            agents.put(name,agent);
            return true;
        }
        else if(2000<=agentType.getCode() && agentType.getCode()<2100){
            Agent agent = new ChatGPTAgentRaw(api);
            agents.put(name,agent);
            return true;
        }
        else {
            log.error("Exception happened when trying to put an agent. " +
                    "The params are: \n name:{}\nagentType:{}\napi:{}",name,agentType,api);
            return false;
        }
    }

    public String chat(String name, String prompt, ArrayList<String> responses, ArrayList<Integer> respPointer){
        return Optional.ofNullable(getAgent(name))
                .map(agent -> agent.chat(prompt, responses, respPointer))
                .orElse(null);
    }

    public String regenerate(String name, ArrayList<String> responses, ArrayList<Integer> respPointer) {
        return Optional.ofNullable(getAgent(name))
                .map(agent -> agent.reGenerate(responses, respPointer))
                .orElse(null);
    }

    public String regenerate(String name,String prompt, ArrayList<String> responses, ArrayList<Integer> respPointer) {
        return Optional.ofNullable(getAgent(name))
                .map(agent -> agent.reGenerate(prompt,responses, respPointer))
                .orElse(null);
    }

    public ArrayList<ChatMessage> getHistory(String name){
        return Optional.ofNullable(getAgent(name))
                .map(Agent::getHistory)
                .orElse(null);
    }

    /**
     * Will try to close and remove an agent from this service.
     * @param name
     * @return True if delete an existed agent successfully, false if the agent is not existed.
     */
    public boolean removeAgent(String name){
        Agent agent = agents.remove(name);
        if (agent==null){
            return false;
        }
        else {
            agent.close();
            return true;
        }
    }


    /**
     * <p> This is a private method. Just, don't take agent out of here.
     *
     * <p> <b>Don't.</b>
     * @param name The name of agent.
     * @return Agent, null if not existed.
     */
    private Agent getAgent(String name){
        if(agents.containsKey(name)){
            return agents.get(name);
        }
        else {
            log.error("Agent name not existed!");
            return null;
        }
    }

    public void closeAll(){
        for (Agent agent: agents.values()){
            agent.close();
        }
    }


}
