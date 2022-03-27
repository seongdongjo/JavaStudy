package ch14;

import java.util.HashMap;
import java.util.Iterator;


public class MemberHashMap {

	private HashMap<Integer, Member> hashMap;
	
	public MemberHashMap()
	{
		hashMap = new HashMap<Integer, Member>();
	}
	
	public void addMember(Member member){
		
		hashMap.put(member.getMemberId(), member); //key, value로 넣기
		
	}
	
	public boolean removeMember(int memberId){
		
		if(hashMap.containsKey(memberId)){ //containsKey, containsValue는 반환값이 boolean이다.
			hashMap.remove(memberId);
			return true;
		}
		
		System.out.println(memberId + "가 존재하지 않습니다");
		return false;
	}
	
	public void showAllMember(){
		Iterator<Integer> ir = hashMap.keySet().iterator(); //map자체에는 Iterator가 없으므로 key 또는 value에서 가져와야함
		while (ir.hasNext()){
			int key = ir.next();
			Member member = hashMap.get(key); //value가 반환된다.
			System.out.println(member);
		}	
		System.out.println();
	}
}
