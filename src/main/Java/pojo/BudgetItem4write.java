package pojo;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 概算条目对象，包含定额编号、工程项目名称、单位、数量、单价、合价，共六个属性值。
 *
 * @author dazuo
 * @Date 2021.02.24
 * @version 1.0.0
 */

public class BudgetItem4write {
    //@ExcelProperty(index = 0)
    @ExcelProperty({"序列号"})
    private String serialnumberofstandard;

    //@ExcelProperty(index = 1)
    @ExcelProperty({"工程项目名称"})
    private String nameofprojectorcost;

    //@ExcelProperty(index = 2)
    @ExcelProperty({"单位"})
    private String unit;

    //@ExcelProperty(index = 3)
    @ExcelProperty({"数量"})
    private float quantity;

    //@ExcelProperty(index = 4)
    @ExcelProperty({"单价"})
    private float unitprice;

    //@ExcelProperty(index = 5)
    @ExcelProperty({"合价"})
    private float combinedprice;

    public BudgetItem4write() {
    }

    public String getSerialnumberofstandard() {
        return serialnumberofstandard;
    }

    public void setSerialnumberofstandard(String serialnumberofstandard) {
        this.serialnumberofstandard = serialnumberofstandard;
    }

    public String getNameofprojectorcost() {
        return nameofprojectorcost;
    }

    public void setNameofprojectorcost(String nameofprojectorcost) {
        this.nameofprojectorcost = nameofprojectorcost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(float unitprice) {
        this.unitprice = unitprice;
    }

    public float getCombinedprice() {
        return combinedprice;
    }

    public void setCombinedprice(float combinedprice) {
        this.combinedprice = combinedprice;
    }
}
