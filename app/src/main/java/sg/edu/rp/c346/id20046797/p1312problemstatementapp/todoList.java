package sg.edu.rp.c346.id20046797.p1312problemstatementapp;

import java.io.Serializable;

public class todoList implements Serializable {

    private int _id;
    private String moduleName;
    private String moduleDescription;
    private String moduleAdditionalInfo;

    public todoList(int _id, String moduleName, String moduleDescription, String moduleAdditionalInfo) {
        this._id = _id;
        this.moduleName = moduleName;
        this.moduleDescription = moduleDescription;
        this.moduleAdditionalInfo = moduleAdditionalInfo;
    }

    public todoList(int _id, String moduleName, String moduleDescription) {
        this._id = _id;
        this.moduleName = moduleName;
        this.moduleDescription = moduleDescription;
        this.moduleAdditionalInfo = "No Information was Given";
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleDescription() {
        return moduleDescription;
    }

    public void setModuleDescription(String moduleDescription) {
        this.moduleDescription = moduleDescription;
    }

    public String getModuleAdditionalInfo() {
        return moduleAdditionalInfo;
    }

    public void setModuleAdditionalInfo(String moduleAdditionalInfo) {
        this.moduleAdditionalInfo = moduleAdditionalInfo;
    }

}
