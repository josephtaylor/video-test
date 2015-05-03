# video-test

This is a super basic example showing project setup for using the processing video library from the [processing-deps](http://github.com/josephtaylor/processing-deps)
project.

### Building the project
`mvn clean package` will generate a runnable jar in the `target` directory.

### Running the project from the target dir
`java -jar video-test.jar`

### Things to note
the imports for the video library in the pom correspond to what is installed via processing-deps: 
   
```
<dependency>
    <groupId>org.processing</groupId>
    <artifactId>processing-video</artifactId>
    <version>1.0</version>
</dependency>
<dependency>
    <groupId>org.processing</groupId>
    <artifactId>processing-video-gstreamer</artifactId>
    <version>1.0</version>
</dependency>
<dependency>
    <groupId>org.processing</groupId>
    <artifactId>processing-video-jna</artifactId>
    <version>1.0</version>
</dependency>
```



The system properties have to be set as follows (this example is for windows 64-bit with `processing-deps` living in `C:\dev`:

`-Djna.library.path=C:\dev\processing-deps\video\windows64`  
`-Dgstreamer.library.path=C:\dev\processing-deps\video\windows64`  
`-Dgstreamer.plugin.path=C:\dev\processing-deps\video\windows64\plugins`  

If you are on mac use the macosx folders.  
If you're on Linux it should just work automagically!