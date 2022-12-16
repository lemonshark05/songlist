import java.util.Date;
/**
 * @author zhimin
 * @version 1.1
 */
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

    /**
     * @param name
     */
    public Entity(String name) {
        this.name = name;
        entityCounter++;
        this.entityID = entityCounter;
        dataCreated = new Date();
    }

    /**
     * @param id
     * @param name
     */
    public Entity(int id, String name) {
        this.name = name;
        entityCounter++;
        this.entityID = id;
        dataCreated = new Date();
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public static int getEntityCounter() {
        return entityCounter;
    }

    /**
     * @param entityCounter
     */
    public static void setEntityCounter(int entityCounter) {
        Entity.entityCounter = entityCounter;
    }

    public int getEntityID() {
        return entityID;
    }

    /**
     * @param entityID
     */
    public void setEntityID(int entityID) {
        this.entityID = entityID;
    }

    /**
     * @return
     */
    public Date getDataCreated() {
        return dataCreated;
    }

    /**
     * @param dataCreated
     */
    public void setDataCreated(Date dataCreated) {
        this.dataCreated = dataCreated;
    }

    /**
     * @param other
     * @return
     */
    public boolean equals(Entity other){
        return this.entityID == other.entityID;
    }

    /**
     * @return
     */
    public String toString(){
        return String.format("%d %s", entityID, name);
    }

    /**
     * @return
     */
    public String toHTML(){
        return "<b>"+this.name+"</b><i>"+this.entityID+"</i>";
    }

    /**
     * @return
     */
    public String toXML(){
        return "<entity><name>"+this.name+"</name><entityID>"+this.entityID+"</entityID></entity>";
    }
}
