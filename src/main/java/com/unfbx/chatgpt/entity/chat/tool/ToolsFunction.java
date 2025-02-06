package com.unfbx.chatgpt.entity.chat.tool;


import com.unfbx.chatgpt.entity.chat.Parameters;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ToolsFunction implements Serializable {

    

    private String name;
    

    private String description;
    

    private Parameters parameters;
}
