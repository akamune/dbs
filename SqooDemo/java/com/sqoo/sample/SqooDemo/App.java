package com.sqoo.sample.SqooDemo;

//import org.apache.sqoop.SqoopOptions;
//import org.apache.sqoop.tool.ImportTool;
import com.cloudera.sqoop.SqoopOptions;
import com.cloudera.sqoop.tool.ImportTool;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static final String DBURL = "jdbc:mysql://localhost/exm";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123";         
    private static final String TARGET_DIR = "hdfs://localhost:8020/user/cloudera/hello";
    private static final String TABLE = "tbl";
    private static final String SUCCESS = "SUCCESS !!!";
    private static final String FAIL = "FAIL !!!";

    
    
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        int retVal = 0;
        SqoopOptions options = new SqoopOptions(DBURL,TABLE);
        options.setUsername(USERNAME);
        options.setPassword(PASSWORD);
        options.setTableName(TABLE);
        options.setTargetDir(TARGET_DIR);
        options.setNumMappers(1);
        options.setDirectMode(false);
        ImportTool it = new ImportTool();
        retVal = it.run((com.cloudera.sqoop.SqoopOptions) options);
        
        
        if(retVal == 0){
               System.out.println(SUCCESS);     
        }
        else{
        	System.out.println(FAIL);     
        	}
        System.out.println( "Job Finished !!!!!!!!!!!" );     
    }
}
