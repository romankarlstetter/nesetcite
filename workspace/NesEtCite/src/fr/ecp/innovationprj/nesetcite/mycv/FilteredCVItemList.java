package fr.ecp.innovationprj.nesetcite.mycv;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;


public class FilteredCVItemList extends AbstractList<CVItem> {

	private List<CVItem> list;
	private String category;
	
	public FilteredCVItemList() {
		list  = new ArrayList<CVItem>();
		category = "";
	}
	
	public void setCategory(String c){
		category = c;
	}
	
	public void setList(List<CVItem> l){
		list = l;
	}
	
	public String getCategory(){
		return category;
	}
	
	@Override
	public CVItem get(int location) {
		int count = 0;
		for (int i = 0; i< list.size(); i++){
			if(count == location){
				return list.get(i);
			}
			if(list.get(i).getCategory().equals(category)){
				count++;
			}
		}
		throw new ArrayIndexOutOfBoundsException(location);
	}

	@Override
	public int size() {
		int count = 0;
		for (int i = 0; i< list.size(); i++){
			if(list.get(i).getCategory().equals(category)){
				count++;
			}
		}
		return count;
	}

	

	
}
