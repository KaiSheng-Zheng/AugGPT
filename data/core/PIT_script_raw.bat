@echo off
echo command:
echo java -cp PIT_LIB;TARGET_PATH;TEST_PATH;
echo         org.pitest.mutationtest.commandline.MutationCoverageReport \
echo         --reportDir REPORT_DIR
echo         --targetClasses TARGETS
echo         --targetTests com.your.package.*
echo         --sourceDirs SRC_DIR
echo         --mutableCodePaths TARGET_PATH
echo         --targetTests TESTS
echo         --outputEncoding UTF-8
echo running...

cd PIT_PATH

%JAVA_HOME%/bin/java.exe -version

%JAVA_HOME%/bin/java.exe -cp PIT_LIB;TARGET_PATH;TEST_PATH; org.pitest.mutationtest.commandline.MutationCoverageReport --reportDir REPORT_DIR --sourceDirs SRC_DIR --targetClasses TARGETS --mutableCodePaths TARGET_PATH --targetTests TESTS --outputEncoding UTF-8 --verbose --threads 1

echo done
