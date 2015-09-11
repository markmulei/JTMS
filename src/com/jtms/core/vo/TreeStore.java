package com.jtms.core.vo;

import java.util.ArrayList;
import java.util.List;

public class TreeStore {

	private String id;
	private String text;
	private boolean checked;
	private boolean leaf;
	private List<TreeStore> children = new ArrayList<TreeStore>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean getChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean getLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public List<TreeStore> getChildren() {
		return children;
	}

	public void setChildren(List<TreeStore> children) {
		this.children = children;
	}

}
