package main;

public class Module
{
	private String moduleName, moduleID, resistorID, qtyResistor, capacitorID,
	qtyCapacitor;

	public Module()
	{
		this.moduleName = "";
		this.moduleID = "";
		this.resistorID = "";
		this.qtyResistor = "";
		this.capacitorID = "";
		this.qtyCapacitor = "";
	}

	public String getModuleName()
	{
		return moduleName;
	}

	public void setModuleName(String moduleName)
	{
		this.moduleName = moduleName;
	}

	public String getModuleID()
	{
		return moduleID;
	}

	public void setModuleID(String moduleID)
	{
		this.moduleID = moduleID;
	}

	public String getResistorID()
	{
		return resistorID;
	}

	public void setResistorID(String resistorID)
	{
		this.resistorID = resistorID;
	}

	public String getQtyResistor()
	{
		return qtyResistor;
	}

	public void setQtyResistor(String qtyResistor)
	{
		this.qtyResistor = qtyResistor;
	}

	public String getCapacitorID()
	{
		return capacitorID;
	}

	public void setCapacitorID(String capacitorID)
	{
		this.capacitorID = capacitorID;
	}

	public String getQtyCapacitor()
	{
		return qtyCapacitor;
	}

	public void setQtyCapacitor(String qtyCapacitor)
	{
		this.qtyCapacitor = qtyCapacitor;
	}
	
	public String toString()
	{
		return new String("\n ModuleName: " + getModuleName() + "\n ModuleID: " + getModuleID() + "\n ResistorID: " + getResistorID()
		+ "\n QtyResistor: " + getQtyResistor() + "\n CapacitorID: " + getCapacitorID() + "\n QtyCapacitor: " + getQtyCapacitor());
	}
	
}
