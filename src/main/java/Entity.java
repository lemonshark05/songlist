import java.util.Date;

public class Entity {
    protected String name;
    protected static int entityCounter = 0;
    protected int entityID;
    protected  Date dataCreated;
    
    public Entity() {
        this.name = "";
        entityCounter++;
        this.entityID = entityCounter;
        dataCreated = new Date();
    }
    
    public Entity(String name) {
        this.name = name;
        entityCounter++;
        this.entityID = entityCounter;
        dataCreated = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getEntityCounter() {
        return entityCounter;
    }

    public static void setEntityCounter(int entityCounter) {
        Entity.entityCounter = entityCounter;
    }

    public int getEntityID() {
        return entityID;
    }

    public void setEntityID(int entityID) {
        this.entityID = entityID;
    }

    public Date getDataCreated() {
        return dataCreated;
    }

    public void setDataCreated(Date dataCreated) {
        this.dataCreated = dataCreated;
    }

    public boolean equals(Entity other){
        return this.entityID == other.entityID;
    }

    public String toString(){
        return String.format("%d %s", entityID, name);
    }

    public String toHTML(){
        return "<b>"+this.name+"</b><i>"+this.entityID+"</i>";
    }

    public String toXML(){
        return "<entity><name>"+this.name+"</name><entityID>"+this.entityID+"</entityID></entity>";
    }
}
