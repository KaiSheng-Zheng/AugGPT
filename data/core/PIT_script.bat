@echo off
echo command:
echo java -cp D:\Coding\Creative\submit\AugGPT\data\lib\PIT\*;D:\Coding\Creative\submit\AugGPT\data\lib\Junit5\*;D:\Coding\Creative\submit\AugGPT\data\targets;D:\Coding\Creative\submit\AugGPT\data\tests;
echo         org.pitest.mutationtest.commandline.MutationCoverageReport \
echo         --reportDir D:\Coding\Creative\submit\AugGPT\data\PITReport\2025-01-24-20-44-46
echo         --targetClasses MyCalendar,MyDate
echo         --targetTests com.your.package.*
echo         --sourceDirs D:\Coding\Creative\submit\AugGPT\data
echo         --mutableCodePaths D:\Coding\Creative\submit\AugGPT\data\targets
echo         --targetTests MyCalendarTest
echo         --outputEncoding UTF-8
echo running...

cd D:\Coding\Creative\submit\AugGPT\data\lib\PIT

%JAVA_HOME%/bin/java.exe -version

%JAVA_HOME%/bin/java.exe -cp D:\Coding\Creative\submit\AugGPT\data\lib\PIT\*;D:\Coding\Creative\submit\AugGPT\data\lib\Junit5\*;D:\Coding\Creative\submit\AugGPT\data\targets;D:\Coding\Creative\submit\AugGPT\data\tests; org.pitest.mutationtest.commandline.MutationCoverageReport --reportDir D:\Coding\Creative\submit\AugGPT\data\PITReport\2025-01-24-20-44-46 --sourceDirs D:\Coding\Creative\submit\AugGPT\data --targetClasses MyCalendar,MyDate --mutableCodePaths D:\Coding\Creative\submit\AugGPT\data\targets --targetTests MyCalendarTest --outputEncoding UTF-8 --verbose --threads 1

echo done
