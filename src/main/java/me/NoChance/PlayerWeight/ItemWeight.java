package me.NoChance.PlayerWeight;

import org.bukkit.inventory.ItemStack;

public class ItemWeight extends ItemStack {

	private double weight;

	public ItemWeight(ItemStack i) {
		super(i);
		this.weight = getConfigWeight();
	}

	public ItemWeight() {
		this.weight = 0;
	}

	public static double getItemWeight(ItemStack i) {
		if (i == null)
			return 0;
		else
			return new ItemWeight(i).getWeight();
	}

	public double getWeight() {
		return this.getAmount() * weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getMaterial() {
		short durability = this.getDurability();
		if (durability > 0)
			return this.getType().toString() + "," + durability;
		return this.getType().toString();
	}

	private double getConfigWeight() {
		return PlayerWeight.plugin.getConfig().getDouble(getMaterial());
	}
}
