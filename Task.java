
/**
 * Task. This class hold information about a game task.
 * 
 * @author Andrew Yiannaki
 * @version v1.0 15/05/2015
 */
public class Task
{
    // instance variables - replace the example below with your own
    private String taskName;
    private int taskTimeLimit;
    private String taskDescription;
    private boolean taskCompleted;
    private boolean taskInProgress;

    /**
     * Constructor for objects of class Task
     */
    public Task(String taskName, int taskTimeLimit, String taskDescription)
    {
        this.taskName = taskName;
        this.taskTimeLimit = taskTimeLimit;
        this.taskDescription = taskDescription;
        this.taskCompleted = false;
        this.taskInProgress = false;
    }
    
    /**
     * getTaskName. Return the task name
     * 
     * @return String  taskName
     */
    public String getTaskName()
    {
        return taskName;
    }
    
    /**
     * getTaskTimeLimit. Return the task time limit
     * 
     * @return int  taskTimeLimit
     */
    public int getTaskTimeLimit()
    {
        return taskTimeLimit;
    }
    
    /**
     * getTaskDescription. Return the task description
     * 
     * @return String  taskDescription
     */
    public String getTaskDescription()
    {
        return taskDescription;
    }
    
    /**
     * getTaskCompleted. Return the flag to indicate if the task has been completed
     * 
     * @return boolean  taskCompleted
     */
    public boolean getTaskCompleted()
    {
        return taskCompleted;
    }

    /**
     * getTaskInProgress. Return the flag to indicate if the task is in progress
     * 
     * @return boolean  taskInProgress
     */
    public boolean getTaskInProgress()
    {
        return taskInProgress;
    }
}
