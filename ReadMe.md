##Question and Answer Project

It is done by  NetBeans (8.0.2) development environment as a Maven project, with CommandLine. There is not a GUI part of the project, because of this reason user makes choice from command line. For example, user chooses 1 or 2 from console. 

•	Spring Boot, 
•	JPA Repository, 
•	Java JDK 1.8
•	H2 database is used

I used H2 because it was easy to use and no need to install any database. But it stores all the data after every run of the project. 

To run the project: (From a development tool)
Open the project at development environment like Eclipse or NetBeans. “Build with Dependencies” and then “Run”.


To run the project: (From cmd/terminal)
Download the source code and go to the root directory of the project. Then run these two commands:

export PATH=/YOUR_LOCAL_LOCATION/apache-maven-3.6.41/bin:$PATH

mvn exec:java


To run the test files:
make sure that skiptest parameter is set to false, I made true to avoid test files to run when project’s other source files are building.

       <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.12.4</version>
                <configuration>
                    <skipTests>false</skipTests>
                </configuration>
            </plugin>  
