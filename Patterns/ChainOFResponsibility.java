package Patterns;

interface SupportHandler{
    void handleRequest(Request request);
    void setNextHandler(SupportHandler nextHandler);
}

class Level1SupportHandler implements SupportHandler {
    private SupportHandler nextHandler;
    @Override
    public void handleRequest(Request request) {
        if (request.getPriority() == Priority.BASIC) {
            System.out.println("Level1 Support handled the request");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
    
    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

class Level2SupportHandler implements SupportHandler{
    private SupportHandler nextHandler;
    
    @Override
    public void handleRequest(Request request) {
        if(request.getPriority() == Priority.INTERMEDIATE){
            System.out.println("Level 2 support handled the request");
        }
        else if(nextHandler != null){
            nextHandler.handleRequest(request);
        }
    }
    
    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
class Level3SupportHandler implements SupportHandler{
    
    @Override
    public void handleRequest(Request request) {
        if(request.getPriority() == Priority.CRITICAL){
            System.out.println("Level 3 Support handled the request");
        }
        else{
            System.out.println("Request  cannot be handled");
        }
    }
    @Override
    public void setNextHandler(SupportHandler nextHandler) {
    }
}

class Request {
    private Priority priority;
    
    public Request(Priority priority) {
        this.priority = priority;
    }
    
    public Priority getPriority() {
        return priority;
    }
}

// Priority Enum
enum Priority {
    BASIC, INTERMEDIATE, CRITICAL
}

public class ChainOFResponsibility{
    
    public static void main(String[] args){
        
        SupportHandler level1Handler = new Level1SupportHandler();
        SupportHandler level2Handler = new Level2SupportHandler();
        SupportHandler level3Handler = new Level3SupportHandler();
        
        level1Handler.setNextHandler(level2Handler);
        level2Handler.setNextHandler(level3Handler);
        
        Request request1 = new Request(Priority.BASIC);
        Request request2 = new Request(Priority.INTERMEDIATE);
        Request request3 = new Request(Priority.CRITICAL);
        
        level1Handler.handleRequest(request1);
        level1Handler.handleRequest(request2);
        level1Handler.handleRequest(request3);
    
    
    
    }
    
    





}
