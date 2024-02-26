문제) 문자열과 문자를 받고 해당 문자가 문자열에서 몇번나오는지?<br>
ex) compucc -> c가 3번<br>

```
    class Main{	
	public int solution(String str, char t){
		int answer=0;
		//대소문자 구분이 없으므로 그냥 대문자로 통일했다.
		str=str.toUpperCase();
		t=Character.toUpperCase(t);
		//System.out.println(str+" "+t);
		/*for(int i=0; i<str.length(); i++){
			if(str.charAt(i)==t) answer++;
		}*/
		
		//foreach쓸려면 배열 등 이 와야해서 str.toCharArray로 배열로만들었다 
		for(char x : str.toCharArray()){
			if(x==t) answer++;
		}
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main(); //함수를 호출하기위해 객체생성(Main)
		Scanner kb = new Scanner(System.in);
		String str=kb.next(); //문자열 입력받고
		char c=kb.next().charAt(0); //문자하나 입력받고
		System.out.print(T.solution(str, c));
	}
}
```
문) 대소문자 변환 ex) StuDY -> sTUdy<br>
```
    class Main {	
	public String solution(String str){
		String answer="";
		for(char x : str.toCharArray()){ //문자열을 문자 하나씩
			if(Character.isLowerCase(x)) answer+=Character.toUpperCase(x); //소문자일때 대문자로 변환
			else answer+=Character.toLowerCase(x);

		}
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.print(T.solution(str)); //함수로 문자열 전달
	}
}
```
또 다른 대소문자 변환 풀이<br>
```
#)소문자 97~122, 대문자 65~90 (소문자-32 = 대문자)
import java.util.*;
class Main {	
	public String solution(String str){
		String answer="";
		for(char x : str.toCharArray()){
			//소문자면 대문자로
			if(x>=97 && x<=122) answer+=(char)(x-32); //char없으면 숫자로계산됨 
			//대문자면 소문자로
			else answer+=(char)(x+32);
		}
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.print(T.solution(str));
	}
}
```
#)문장을 입력받아 가장 긴 단어 출력, 길이가 같으면 젤 앞의 단어 출력<br>
```
    class Main {
        public String solution(String str) {
            String answer="";
            int m = Integer.MIN_VALUE;
            String[] s = str.split(" "); //공백을 기준으로 잘라서 넣는다. split은 고정배열로만 들어간다. List에는 안들어간다.<br>
            for(String x : s) {
                int len = x.length();
                if(len > m) {
                    m = len; //m보다 크다면 저장
                    answer = x
                }
            }
            return answer;
        }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        }
    }
```
#)또 다른 풀이<br>
```
    class Main {	
	public String solution(String str){
		String answer="";
		int m=Integer.MIN_VALUE, pos;
		while((pos=str.indexOf(' '))!=-1){ //첫위치의 공백찾기 (반복)
			String tmp=str.substring(0, pos); //첫위치의 공백까지
			int len=tmp.length();
			if(len>m){
				m=len;
				answer=tmp;
			}
			str=str.substring(pos+1);
		}
		//위에까지 돌리면 마지막 공백 앞 문장까지 읽는다.
		//그래서 마지막 문자열은 못읽어서 아래처럼 비교한다.
		if(str.length()>m) answer=str; //마지막은 공백처리가 안되기때문에 마지막은 그냥 바로 비교
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.nextLine();
		System.out.print(T.solution(str));
	}
}
```
#)문자 뒤집기<br>
```
    class Main {
	public ArrayList<String> solution(int n, String[] str){
		ArrayList<String> answer=new ArrayList<>(); 
		for(String x : str){ //stringBuilder도 지원하는 메서드가 많다.
			//String은 값자체는 못바꾸기때문에 객체를 계속만들어야한다. 근데
			//StringBuilder는 해당 값에서 바꿀수있다.
            //StringBuilder객체를 만드는 이유: 
			//String으로 객체를 만들면 toString이런거 하면 새로운객체를 계속만든다.
			//그래서 StringBuilder를 써서 replace, toString이런거 써도 하나의 객체만을 이용
			String tmp=new StringBuilder(x).reverse().toString(); //for문 돌릴때마다 new할필요없이 값을 바꾸니까 new안해도됨
			answer.add(tmp); //문자열을 배열에 추가
		}
		return answer; //arrayList로 반환
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt(); //몇개단어를 입력할지
		String[] str=new String[n]; //단어 입력
		for(int i=0; i<n; i++){
			str[i]=kb.next(); //단어입력
		}
		for(String x : T.solution(n, str)){
			System.out.println(x);
		}
	}
}
//결과:
//3
//good
//time
//Big
//doog
//emit
//giB
```
#)또 다른 풀이<br>
```
//lt          rt 
//0  1  2  3  4
//s  t  u  d  y
import java.util.*;
class Main {
	public ArrayList<String> solution(int n, String[] str){
		ArrayList<String> answer=new ArrayList<>(); 
		for(String x : str){ //str에는 time, dog, good
			char[] s=x.toCharArray(); //time을 문자로 하나씩 배열에 저장
			int lt=0, rt=x.length()-1; //맨오른쪽값을 위한
			while(lt<rt){
				char tmp=s[lt]; //맨왼쪽의 값을 임시로 저장
				s[lt]=s[rt]; //맨오른쪽에 있는값을 맨왼쪽으로 스멀스멀
				s[rt]=tmp; //임시로 넣었던 맨왼쪽에 있는값을 오른쪽으로 스멀스멀
				lt++;
				rt--;
			}
			String tmp=String.valueOf(s); //valueOf는 static메서드라 String.으로접근
			answer.add(tmp);
		}
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		String[] str=new String[n];
		for(int i=0; i<n; i++){
			str[i]=kb.next();
		}
		for(String x : T.solution(n, str)){
			System.out.println(x);
		}
	}
}
```
문제) 특정문자 뒤집기(알파벳만) 특수문자는 그대로
```
    import java.util.*;
class Main {	
	public String solution(String str){
		String answer;
		char[] s=str.toCharArray(); //문자열 받아서 하나하나 배열로
		int lt=0, rt=str.length()-1;
		while(lt<rt){ //아래 분기문을 보면 즉, 둘다 알파벳일 떄만 교환한다. 
			if(!Character.isAlphabetic(s[lt])) lt++; //lt가 특수문자면
			else if(!Character.isAlphabetic(s[rt])) rt--; //rt가 특수문자면
			else{ //특수문자가 아니면 둘다 알파벳이니까 교환
				char tmp=s[lt];
				s[lt]=s[rt];
				s[rt]=tmp;
				lt++;
				rt--;
			}
		}
		answer=String.valueOf(s); //char[]을 String으로 전환
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.println(T.solution(str));
	}
}
```
문제를 보기전에 indexOf의 개념부터<br>

```
    class Main {
        public static void main(String args[]) {
            String s = "Hello Hi World";
            
            System.out.println(s.indexOf("e")); //1
            System.out.println(s.indexOf("H")); //0 (앞에서 문자만 찾음)
            System.out.println(s.indexOf("w")); //-1 (없으면 -1 반환)
            System.out.println(s.indexOf("l",5)); //12 (5번째위치부터 찾아라)

            System.out.println(s.lastIndexOf("H")); //6 (맨마지막에 나오는 H)
            System.out.println(s.lastIndexOf("H",8)); //6 (8번째까지 짜르고 H가 나오는 마지막 인덱스)
        }
    }
```
#)중복문자 제거
```
public class Collapse {
	public String solution(String str) {
		String answer="";
		for(int i = 0; i<str.length(); i++) { 
			//indexOf는 0부터 계속시작(처음발견된 문자는 i와 str.indexOf(str.charAt(i) 두개의 값이 같다.
			//앞에 중복된 문자가 있으면  indexOf와 for문의 i와 같다.
			//중복이 아니면 해당 인덱스위치 반환
			//str.charAt(i)와 i가 같다는것은 처음이자 중복되지않는걸 answer에 저장한다는거다
			//System.out.println(str.charAt(i)+" "+str.indexOf(str.charAt(i))+" "+ i );
			// k 0 0
			// s 1 1 
			// e 2 2
			// k 0 3   	
			if(str.indexOf(str.charAt(i))==i) answer+=str.charAt(i); //str.indexOf(str.charAt(i)) i번쨰 문자가 몇번쨰인덱스인지 k라면 0
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Collapse T= new Collapse();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(T.solution(str));
	}

}
```
#)회문문자열인지 검사(대소문자 구분x)
```
    public class Circular {
	public String solution(String str) {
		String answer="YES";
		str=str.toUpperCase();
		int len = str.length();
		for(int i=0; i<len/2; i++) { //절반으로 자른다. liner (li까지 반복)
			if(str.charAt(i)!=str.charAt(len-i-1)) return "NO"; //맨끝과 처음비교 스멀스멀  
		}
		return answer;
	}
	public static void main(String[] args) {
		Circular T = new Circular();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(T.solution(str));
	}
}
```
또다른 풀이
```
    public class Circular {
	public String solution(String str) {
		String answer="NO";
		//tmp에는 뒤집은 str이 들어간다.
		String tmp = new StringBuilder(str).reverse().toString();
		//str은 안뒤집어진거, equalsIgnore은 대,소문자 구분안하고 비교
		if(str.equalsIgnoreCase(tmp)) answer="YES";
		
		return answer;
	}
	public static void main(String[] args) {
		Circular T = new Circular();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(T.solution(str));
	}
}
```
#)앞에서 읽을 때나 뒤에서 읽을 떄나 같은 문자열을 팰린드롬이라고 한다.<br>
알파벳말고 나머지들은 다 제거해야한다(대소문자도 구분안한다)<br>
#)time7; study, ydust; 7emit;; 이렇게 들어와도 YES를 출력해야된다.<br>
```
   public class Main {
	public String solution(String s) {
		String answer="NO";
		//대문자로 바꾼후, 알파벳빼고 다제거(대문자A-Z아니면 빈문자화시켜라)
		s=s.toUpperCase().replaceAll("[^A-Z]","");
		String tmp = new StringBuilder(s).reverse().toString();
		if(s.equals(tmp)) answer="YES";
		
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str = kb.nextLine();
		System.out.println(T.solution(str));
	}
} 
```
#)뒤집고 자연수로<br>
#)알파벳과 숫자가 섞여 있는 문자열이 주어지면 숫자만 추출하여 그 순서대로 자연수를 만든다.<br>
#)tae01aex23 -> 0123 -> 123으로 출력되야한다.(앞에 0은 제외)<br>
```
    public class Grasp {
	public int solution(String s) {
		int answer = 0;
		for(char x : s.toCharArray()) {
			//이 범위에 있으면 문자숫자(0~9) , 맨앞에 0이오면 48을 빼고 0을 곱함으로써 0은 무시
			//누적하기(참고로 48은 char로 표현하면 0이다)
			if(x>=48 && x<=57) answer=answer*10+(x-48); //뒷자리계속 추가추가추가
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Grasp T = new Grasp();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(T.solution(str));
	}
}
```
#)숫자인지체크예제<br>
```
    public class Test {
	public static void main(String args[]) {
		System.out.println(Character.isDigit('c'));
		System.out.println(Character.isDigit('5'));
	}
}   
//출력
//false
//true
```
#)숫자인지체크 문제<br>
```
public class Grasp {
	public int solution(String s) {
		String answer = "";
		for(char x : s.toCharArray()) {
			//x가 숫자면
			if(Character.isDigit(x)) answer+=x;
		}   //문자를 정수형으로 
		return Integer.parseInt(answer); //앞에 숫자가 와도 무시
	}
	
	public static void main(String[] args) {
		Grasp T = new Grasp();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(T.solution(str));
	}
}
```


