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
```
//앞에 19,20년도에 맞게 넣는법
int nowYear = Integer.parseInt(new SimpleDateFormat("yy").format(new Date()));
String year = num1.substring(0, 2); //970103으로받음
String month = num1.substring(2, 4);
String day = num1.substring(4);
String gender = Integer.parseInt(num2.substring(0, 1)) % 2 == 0 ? "여성" : "남성";
year = Integer.parseInt(year) > nowYear ? "19" + year : "20" + year;
```
#)가장짧은 문자거리<br>
#)teacher 로 입력받고 e로 입력받으면 각문자가 e로부터 떨어진거리 구한다.<br>
#)본인위치 가까운 왼쪽e로 부터 먼저 for문돌리고 다시 오른쪽기준으로하는 for문돌린다.<br>
- P의 값(e와 떨어진거리)을 비교해서 작은값으로 교체한다.<br>

#)e는 본인위치니까 0 그 후 e가 아닌것들은 e를 만날때까지 계속 +1증가
```
public class Test1 {
	public int[] solution(String s, char t) {
		int[] answer = new int[s.length()]; //입력받은 길이를 크기로하여 배열선언
		int p = 1000;
		for(int i=0; i<s.length(); i++) { //젤 왼쪽부터(입력받은 길이 만큼 반복)
			if(s.charAt(i)==t) { //여기서 t는 전달받은 인자인 "e"이다. 특정문자와 같은지
				p=0;
				answer[i]=p; //e를 만나면 answer[i] = 0
			}           //여기는 왼쪽에 e기준이된다.
			else {	   // 1001 012012
				p++;  //  t    eaaeaa
				answer[i]=p;
			}
		}
	p=1000;		//거꾸로 시작                  //1011012  : 최종결과, 즉 4번째가 2에서 1로 바뀌었다. 가장 작은값으로 바꾸니까	
	for(int i=s.length()-1; i>=0; i--) {  // teaaeaa
		if(s.charAt(i)==t) p=0; //거꾸로 시작해서 e랑 만나면 0
		else {
			p++;
			answer[i]=Math.min(answer[i], p); //기존값과 p를 비교해서 작은값대입
		}
	}
		return answer;
	}
	
	public static void main(String[] args) {
		Test1 T = new Test1();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		char c = kb.next().charAt(0);
		for(int x : T.solution(str, c)) {
			System.out.println(x+" ");
		}
	}
}
```
#)문자열 압축<br>
#)KKHSSSSSSSE -> K2HS7E 로 출력
```
public class Compress {
	public String solution(String s) {
		String answer=""; //여기에 정답을 넣을 것이다.
		s=s+" ";
		int cnt=1;
		for(int i=0; i<s.length()-1; i++) {
			if(s.charAt(i)==s.charAt(i+1)) cnt++;
			else { //쭉같다가 다르거나, 아예첨부터다르면
				answer+=s.charAt(i); 
				if(cnt>1) answer+=String.valueOf(cnt); //cnt가 1보다클때만 answer에 넣는다. 
				cnt = 1;
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		Compress T = new Compress();
		Scanner kb = new Scanner(System.in);
		String str = kb.next(); //문자열입력
		System.out.println(T.solution(str));
	}
}
```
<h4>아스키테이블</h4>
<img src="https://raw.githubusercontent.com/seongdongjo/JavaStudy/main/%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8%EC%9D%B4%EB%AF%B8%EC%A7%80/ascitable.PNG" width="650" height="400" /><br><br>

7비트 고정길이 코드체계로 영문,숫자,특수문자 등을 표현한다(총128개문자 표현)<br> 
즉, 아스키코드는 영어만을 고려해서 만들어졌다<br>
그렇다면 한글은??<br>
한글을 처리하기위해서 전 세계모든문자를 매핑하는 문자집합인 유니코드가 등장했다.<br>
32비트로(3바이트) 저장하고있다.<br><br>

<h4>ANSI</h4>
8bit로 구성되어있으며 256개의 문자를 표현할 수 있다<br>
ANSI는 ASCII의 확장판이라 생각하면된다.<br>
ANSI의 앞 7bit는 ASCII와 동일하고, 뒤에 1bit를 이용하여 다른언어의 문자를 표현한다.<br>
ANSI = ASCII(7bit) + CodePage(1bit) 이다.<br>
영어만 사용하거나 ASCII를 사용할경우 세계어디에서나 문제없다<br>
영어 외 다른 언어를 사용할 경우 ANSI는 Code Page를 동일하게 맞춰야한다<br>

```
EUC-KR
EUC-KR은 한글 지원을 위해 유닉스 계열에서 나온 완성형 코드 조합이다.
완성형 코드란 완성 된 문자 하나하나마다 코드 번호를 부여한 것이다. 
반대되는 개념으로 조합형 코드가 있는데, 이는 한글의 자음과 모음 각각에 코드 번호를 부여한 후 초성, 중성, 종성을 조합하여 하나의 문자를 나타내는 방식을 말한다.
EUC-KR은 ANSI를 한국에서 확장한 것으로 외국에서는 지원이 안 될 가능성이 높다.
```

```
유니코드는 2바이트(16비트)를 써서 2의16승을 표현한다 65536가지이다.
참고로 '가' 는 유니코드로 U+AC00이다 즉, 이렇게 하나씩 다 매핑되있다.

UTF-8은 유니코드를 인코딩하는 방식이다.
UTF-8 인코딩은 유니코드 한문자를 나타내기 위해 1바이트에서 4바이트까지사용한다.
```
#)#은 1로 *은 0으로 읽고 십진수로 변환 후 아스키코드 대문자로 해석 (7개까지 끊어내야한다)
#)몇개의 문자인지도 인자로 넘겨야한다. (4개의 문자라면 7문자씩 4번씩끊어야된다)
```
public class Main {
	public String solution(String s, int n) {
		String answer="";
		for(int i=0; i<n; i++) {  //내 생각에는 여기가 핵심이다. replace
			String tmp=s.substring(0,7).replace('#', '1').replace('*', '0');
			int num = Integer.parseInt(tmp,2); //넘어온 tmp 2진수를 10진수화시킨다.(67, 79, 79, 76)
			answer+=(char)num;
			System.out.println(tmp+" "+num);
			s=s.substring(7); //짜른 이후부터 다시
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		String str = kb.next();
		System.out.println(T.solution(str,n)); //결과가 깨짐
	}
}
//입력
//2
//#######*******  (이렇게 입력이 잘들어갔다는 가정하에)
//결과
1111111 127
0000000 0
```
#)n(1<=n<=100)개의 정수를 입력받아, 자신의 바로 앞 수 보다 큰수만 출력(첫번째 수는 무조건 출력)<br>
```
    public class Main {
	public ArrayList<Integer> solution(int n, int[] arr) {
		ArrayList<Integer> answer = new ArrayList<>(); //최종결과 출력할 answer
		answer.add(arr[0]); //첫번째값은 출력하기 위해
		for(int i = 1; i<n; i++) { //길이 5입력시 0 1 2 3 4 다 검사한다. i가 4(끝)까지
			if(arr[i]>arr[i-1]) answer.add(arr[i]);  //앞수보다 뒷수가 더 크다면
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i]=kb.nextInt();
		}
		for(int x : T.solution(n, arr)) {
			System.out.println(x+ " ");
		}
		kb.close();
	}
}
```
#)필요한 문자만 추출
```
public class DeleteChar {
	static String solution(String new_id) {
		String answer = "";
		//1단계 new_id의 모든 대문자를 소문자로
		new_id = new_id.toLowerCase();
		//2단계 new_id에서 알파벳 소문자, 숫자, 뺴기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
		String test = "abcdefghijklmnopqrstuvwxyz0123456789-_.";
		for(int i=0; i<new_id.length(); i++) { //입력받은 new_id를 문자 하나씩 가져와서 위의 조건이 포함되면 쌓는다.
			if(test.contains(new_id.charAt(i)+"")) { //빈문자열을 더하면 문자열이된다
				answer += new_id.charAt(i);
			}
		}
		//3단계 new_id에서 마침표(.)가 2번이상 연속된 부분을 하나의 마침표(.)로 치환
		while(answer.contains("..")) { //점이 3개이상이여도 while문을 통해 계속 실행 결국 마침표는 하나로된다.
			answer = answer.replace("..", ".");
		}
		//4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거
		if(answer.charAt(0)=='.') {
			answer = answer.substring(1);
		}
		if(answer.length() > 0 && answer.charAt(answer.length()-1)=='.') {
			answer = answer.substring(0,answer.length()-1);
		}
		//5단계 new_id가 빈문자열이라면, new_id에 "a"를 대입
		//변수와 상수간의 비교하면, 상수를 앞에다가 두자
		//만약에 if(answer.equals("")) answer가 null이면 equals라는 메소드가 호출이안된다.
		//상수는("") 항상 널이 아니다. 그러면 널포인터 예외가 발생안한다.
		if("".equals(answer)) { 
			answer="a";
		}
		//6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자모두 제거
		//제거 후 마침표(.)이 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자제거
		if(answer.length() >= 16) {
			answer=answer.substring(0,15);
		}
		if(answer.length()>0 && answer.charAt(answer.length()-1)=='.') {
			answer=answer.substring(0,answer.length()-1);
		}
		//7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이될때까지 반복해서 끝에 붙인다
		while(answer.length() <3) {
			answer += answer.charAt(answer.length()-1);
		}
		return answer;
	}
	public static void main(String[] args) {
		String input = "...!@BaT#*..y.abcdefghijklm";
		String expected="bat.y.abcdefghi";
		
		String result = solution(input);
		System.out.println(expected.equals(result));
	}
}   
```
> #)보이는 학생<br>
N명을 일렬로 세우는데 맨앞에 서있는 선생님이 볼 수 있는 학생의 수?<br>
(단, 앞에 학생들과 같으면 안되고 무조건 커야보인다.)<br>
```
    public class Main {
	public int solution(int n, int[] arr) {
		int answer=1, max = arr[0]; //처음에는 무조건 보이니까 answer = 1
		for(int i=1; i<n; i++) {
			if(arr[i]>max) {
				answer++;
				max=arr[i];
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();  //학생의 수
		int[] arr = new int[n]; //학생의 수만큼 배열 크기 지정
		for(int i = 0; i<n; i++) {
			arr[i]=kb.nextInt(); //학생 키 입력
		}
		System.out.print(T.solution(n,arr));
		kb.close();
	}
}
```
> #)가위,바위,보<br>
A와 B가 가위,바위,보를 하는데 가위=1, 바위=2, 보=3 으로 정의하고 A가 이기면 A로한다.
```
public class Main {
	public String solution(int n, int[] a, int[] b) {
		String answer="";
		for(int i = 0; i<n; i++) {
			//같으면 비긴다.
			if(a[i]==b[i]) answer+="D";
			//a가 이기는 경우 3가지(아래)
			//a가 가위, b가 보
			else if(a[i]==1 && b[i]==3) answer+="A";
			else if(a[i]==2 && b[i]==1) answer+="A";
			else if(a[i]==3 && b[i]==2) answer+="A";
			//b가 이기면
			else answer+="B";
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt(); //몇번의 가위바위보를 할지
		int[] a=new int[n];
		int[] b=new int[n];
		//A,B 가위바위보 입력
		for(int i = 0; i<n; i++) {
			a[i]=kb.nextInt();
		}
		for(int i = 0; i<n; i++) {
			b[i]=kb.nextInt();
		}
		//줄바꿔서 나오게끔
		//함수가 String으로 받아서 문자배열로 변환후 char x에 넣음
		for(char x : T.solution(n,a,b).toCharArray()) System.out.println(x);
		kb.close();
	}
}
```
> 피보나치 수열<br>
입력은 피보나치 수열의 총 개수이다. 만약 7이 입력되면 1 1 2 3 5 8 13 을 출력하면 된다<br>
항의 수는 (3<=n<=45>)사이로 입력해야한다. (즉, 앞에 1 1 은 넣고 시작한다.)
```
    public class Main {
	public int[] solution(int n) {
		int[] answer = new int[n];
		answer[0] = 1;
		answer[1] = 1;
		for(int i = 2; i<n; i++) {
            //이렇게 배열에 담는다.
			answer[i] = answer[i-2]+answer[i-1];
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		for(int x : T.solution(n)) System.out.print(x + " ");
		
		
		kb.close();
	}
}
```
#) 다른 풀이<br>
```
   class Main {
	public void solution(int n) {
		int a = 1, b = 1, c;
		System.out.print(a + " " + b + " ");
		for(int i = 2; i<n; i++) {  //  1 1 2 3 5 8 ..
			c = a+b;
			System.out.print(c+ " ");
			a=b;
			b=c;
		}
	}
	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		T.solution(n);
	}
	
}
```
>소수판별 아리스토테네스의 체<br>
자연수 N이 입력되면 1부터 N까지 범위안에서 소수의 개수를 출력하는 프로그램이다.<br>
```
    class Main {
	public int solution(int n) {
		int answer = 0;
		int[] ch = new int[n+1]; //객체이기 때문에 처음에 다 0으로 세팅되어있다.
		for(int i=2; i<=n; i++) {
			if(ch[i]==0) { //처음에는 for문에서 i가 2부터 시작함 첨에는 0이니까(0은 소수라는 뜻이다)
				answer++; //소수 개수 count 
				//i의 배수로 증가해서 0을 1로 change
				//인덱스의 배수들을 1로 채우기 (j=j+i) -> 배수
				for(int j=i; j<=n; j=j+i) 
					ch[j]=1; 					   //첨에 i가 2일 때 ch[2] = 1; (n<=5라고할때)
												   //i가 2일때, j = 4 ch[4] = 1;
											       //i가 2일때, j = 6 ch[6] = 1;
			}
		}
		return answer;
	}
public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int  n = kb.nextInt(); //자연수 하나 입력
		System.out.println(T.solution(n));
	}
}
```
> 뒤집은 소수<br>
32를 뒤집으면 23 -> 소수<br>
910을 뒤집으면 19 -> 소수
```
입력예제) 9 (입력할 자연수 개수)
         32 55 62 ...
출력예제) 23 (소수만 출력)


public class Main {
	public boolean isPrime(int num) { //소수인지 판별
		if(num == 1) return false; //1은 소수가 아니니까
		for(int i = 2; i<num; i++) { //num이 2이면 i<num에 성립하지 않기때문에 return true로 가서 소수로 판별된다.
			if(num%i == 0) { //i는 자기자신전까지, 나누어 떨어지면 소수가 아니다.
				return false;
			}
		}
		return true;
	}
	//숫자를 거꾸로 뒤집는 작업
	public ArrayList<Integer> solution(int n, int[] arr) {
		ArrayList<Integer> answer = new ArrayList<>();
		
		for(int i = 0; i<n; i++) {
			int tmp = arr[i];
			int res = 0; //0보다 작은수를 입력받아도 res를 넘기기때문에 상관없다.
			while(tmp > 0) { //tmp가 27일때
				int t = tmp % 10; // t = 7     					   t = 2
				res = res * 10 + t; //res = 7  					   res = 72
				tmp = tmp / 10; //tmp = 2 -> 0보다 크니까 다시 while반복 tmp = 0
			}
			if(isPrime(res)) answer.add(res);
		}
		return answer;
	}

	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt(); //입력받을 자연수 개수
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		for(int x : T.solution(n, arr)) { //배열과 갯수 넘긴다.
			System.out.println(x + " ");
		}
	}

}
```
#)점수계산<br>
```
    입력
    8(갯수)
    1
    0
    1
    1
    1
    0
    0
    1
    결과는 8이 나와야한다.
    점수: 1 0 1 2 3 0 0 1  1이 연속할때는 1점씩 증가 => 총 8점이 나와야한다.

    class Main {
	public int solution(int n, int[] arr) {
		int answer = 0; //여기에 점수 누적
		int cnt = 0;
		for(int i = 0; i<n; i++) {
			if(arr[i] == 1) { //1이면은 카운트 증가
				cnt++;
				answer+=cnt;
			}
			else { //0을 만나면 0으로 cnt초기화
				cnt = 0;
			}
		} 
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt(); //개수입력받고
		int[] arr = new int[n];
		for(int i =0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		System.out.println(T.solution(n, arr));
	}
}
```
#)등수구하기<br>
```
class Main {
	public int[] solution(int n, int[] arr) {
		int[] answer = new int[n]; //기본적으로 0으로 초기화되있다.
		
		for(int i=0; i<n; i++) {
			int cnt =1; //처음은 1등
			for(int j=0; j<n; j++) { //요소하나에 다 비교
				if(arr[j] > arr[i]) cnt++; //i가 작을때만 증가(같으면 cnt가 증가하면 안된다 같은점수는 같은등수이다.)
			}
			answer[i] = cnt;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		for(int x : T.solution(n, arr)) System.out.println(x+ " ");
	}
}
```
#) 5 x 5 격자판 계산<br>
각행의 합 , 각 열의 합, 두 대각선의 합 중 가장 큰합을 출력 (두대각선은 2개 밖에없음 ) 이렇게 x자

#) 배열에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return
```
//입력은
5(5개입력 하겠다라는 의미)
2
1
3
4
1
//결과
2
3
4
5
6
7


    public class ByteLegth {
	public int[] solution(int[] numbers) { //배열을 인자로 받는다.
		int[] answer = {};
		
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<numbers.length; i++) {
			for(int j=i+1; j<numbers.length; j++) {
				if(i!=numbers.length-1) { // i가 끝인덱스가아니라면(끝인덱스는 이미 경우의 수가 다 그전에 포함되어있기때문에)
					int res = numbers[i] + numbers[j]; 
					if(!list.contains(res)) list.add(res); //합한값이 배열에 있으면 안 넣는다.
				}
			}
		}
		answer = new int[list.size()]; //위에서 다 더한 리스트를 받아서
		for(int i=0; i<answer.length; i++) {
			answer[i] = list.get(i);
		}
		Arrays.sort(answer);;
		return answer;
	}
	
	public static void main(String[] args) {
		ByteLegth T = new ByteLegth();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int[] answer = T.solution(arr);
		for(int i = 0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}
```

#)10진수 -> 2,8,16진수
```
int num10 = 77;
String num2 = Integer.toBinaryString(num10); // 1001101
String num8 = Integer.toOctalString(num10); // 115 -> 64 + 8 + 5(8의0승*5니까)
String num16 = Integer.toHexString(num10); // 4d -> 16*4 + 13 (d는 13)

//2,8,16 -> 10진수
int num10_2 = Integer.parseInt(num2, 2); // 77
int num10_8 = Integer.parseInt(num8, 8); // 77
int num10_16 = Integer.parseInt(num16, 16); // 77
```

#)준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이가지고있다.<br>
동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다.<br>
이때, 필요한 동전개수의 최솟값을 구하는 프로그램을 작성
```
입력)
첫째 줄에 N과 K를 입력한다. 범위: (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
둘째줄에 동전가치를 입력받는다.(오름차순으로)

출력)
첫째줄에 입력한 K원을 만드는데 필요한 동전개수의 최솟값을 출력한다.

예제입력)
10 4200  
1
5
10
50
100
500
1000
5000
10000
50000
예제출력) 
6  -> 1000원 4개 100원 2개니까 총 6개

public class Main {
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(); //동전 n종류
		int a = scan.nextInt(); //만들고싶은 총 금액
		int arr[] = new int[n];
		int ans = 0;
		
		for(int i=0; i<n; i++) {
			arr[i] = scan.nextInt(); //동전의 가치 오름차순으로 입력받기
		}
		
		while(a!=0) { //돈이 0이 될때까지
			int chk = 0;
			for(int i= arr.length-1;i>=0;i--) { //가장 뒤가 제일 가치가 높으니까 거꾸로 돌린다
				if(arr[i]<=a) { // 입력했던 만들고 싶은금액(a)보다 작으면
					chk=i; //지금 이 돈의 가치가 들어가겠구나! => 값을 넣어준다
					break; 
				}
			}	
				1. 동전개수 구하기
				ans += a / arr[chk]; // 그 돈의 가치로 나눈 몫을 ans 에 더하기(동전개수)
				2. 나머지금액 구하기
				a = a % arr[chk]; // 그돈의 가치로 최대한 넣은 뒤 남은 금액 넣기
                // 다시 while문이 돈다
		}
		System.out.println(ans);
	}
}
```
#) 아파트문제
```
이 아파트에 거주를 하려면 조건이 있는데, 
“a 층의 b 호에 살려면 자신의 아래(a-1)층에서만 1호부터 b 호까지 사람들의 수의 합만큼 사람들을 데려와 살아야한다” 는 계약 조항을 꼭 지키고 들어와야 한다.

아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정 했을 때, 
주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있나를 출력하라.

단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층에만 i호에는 i명이 산다.(0층에 i호에 i명이라는건 0호에0명(의미x,0층만들어감), 1호에1명, 2호에 2명...)

//입력(T는 몇번테스트하고싶은지)
첫 번째줄에 Test case의 수 T가 주어진다. 그리고 각각의 케이스마다 입력으로 첫번째줄에 정수k,
두번째줄에 정수n이 주어진다.(1<=k<=14,1<=n<=14)

//(1<=k<=14,1<=n<=14) 범위는 이렇게인데 [15][15]로 하는 이유는 문제에 0층이 존재하기때문에
그래서 int[][] APT = new int[15][15] 이렇게 테스트 케이스 수만큼 반복적으로 배열을 생성해주기보다는 입력의 최댓값만큼의 배열의 사이즈를 한 번 생성하고 사용하면 더 효율적이다.


#)먼저 초기화작업
for(int i=0; i<15; i++) {
	//1호 전체 1로 초기화
	APT[i][0] = 1;
	//호에 0(0층만),1,2,3,4,5 ..
	APT[0][i] = i;
}

//여기까지가 아래결과
...
2층  x  1
1층  x  1
0층  0  1   2  3 ...
	0호 1호 2호 3호 ...
	

//우리는 14층 14호까지 더해야하는데 규칙을보면 *부위에 대각선으로 더하면 합이 나오는 규칙을 알수있다. 
2층  x  1    4  10
1층  x  1*   3  6
0층  0  1   2*  3 ...
	0호 1호 2호 3호 ... 14호

즉, i층의 직전호(j-1)와 i-1층의 j호 의 합을 채우면 된다.


전체 코드로 본다면
int[][] APT = new int[15][15];
 
for(int i = 0; i < 15; i++) {
	APT[i][1] = 1;	// i층 1호
	APT[0][i] = i;	// 0층 i호
}
 
//나머지는 아래로직대로 채울것이다.
for(int i = 1; i < 15; i ++) {	// 1층부터 14층까지
	for(int j = 2; j < 15; j++) {	// 2호부터 14호까지(1호는 1로 채워져있음)
		APT[i][j] = APT[i][j - 1] + APT[i - 1][j];
	}
}
------------------------------
//완성코드를 보자(k,n을 입력 받을 때마다 APT[n][k]를 출력해주면된다)
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		// 아파트 생성 
		int[][] APT = new int[15][15];
 
		for(int i = 0; i < 15; i++) {
			APT[i][1] = 1;	// i층 1호
			APT[0][i] = i;	// 0층 i호
		}
 
 
		for(int i = 1; i < 15; i ++) {	// 1층부터 14층까지
 
			for(int j = 2; j < 15; j++) {	// 2호부터 14호까지
				APT[i][j] = APT[i][j - 1] + APT[i - 1][j];
			}
		}
		
		// 테스트 부분 (몇번 테스트 할건지)
		int T = in.nextInt();
		
		for(int i = 0; i < T; i++) {
			int k = in.nextInt(); //층
			int n = in.nextInt(); //호
			System.out.println(APT[k][n]); //몇층에 몇호에는 몇명인가
		}
	}
}
#)소스통합
-------------------------------
public class Test1 {
 
	public static int[][] APT = new int[15][15];
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		make_APT();	// 아파트 만들기 
		
		int T = Integer.parseInt(br.readLine());
 
		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			sb.append(APT[k][n]).append('\n'); //이미 아래에서 만든 배열을 여기서는 그냥 출력한다고 생각하면된다.
		}
		System.out.println(sb);
	}
 
	
	public static void make_APT() {
		// 아파트 생성
 
		for (int i = 0; i < 15; i++) {
			APT[i][1] = 1; // i층 1호
			APT[0][i] = i; // 0층 i호
		}
 
		for (int i = 1; i < 15; i++) { // 1층부터 14층까지
 
			for (int j = 2; j < 15; j++) { // 2호부터 14호까지
				APT[i][j] = APT[i][j - 1] + APT[i - 1][j];
			}
		}
	}
 
}
//입력
5 //5번테스트하겠다
1 //(층)
2 //(호) 여기까지 1번
3 
4 //여기까지 2번
5 
1 //여기까지 3번
2
3 //여기까지 4번
4
5 //여기까지 5번
//결과
3
35
1
10
126

```

#)BufferedReader, BufferedWriter는 버퍼를 사용하여 읽기와 쓰기를 하는 함수이다.
```
버퍼를 사용하지 않는 입력은, 키보드의 입력이 키를 누르는 즉시 바로 프로그램에 전달된다.
반면 버퍼를 사용하는 입력은, 키보드의 입력이 있을 때마다 한 문자씩 버퍼로 전송한다. 
버퍼가 가득 차거나 혹은 개행 문자가 나타나면 버퍼의 내용을 한 번에 프로그램에 전달한다.

한번 버퍼를 거쳐 출력되는 것보다, 키보드의 입력을 받는 즉시 출력하는 것이 더 빠른 것이 아닌가 생각할수 있다.
하드디스크는 속도가 느리다. 그리고 외부 장치(키보드, 모니터 등)와 데이터 입출력도 생각보다 시간이 오래 걸린다.
그렇기 때문에 키보드의 입력이 있을 때마다 바로 이동시키는 것 보다는, 중간에 버퍼를 두어 한번에 묶어 보내는 것이 더 효율적이고 빠른 방법이다.

쓰레기통을 비우는 일이라고 생각하면 이해가 쉽다. 
쓰레기가 생길 때마다 하나하나 밖에 내다버리는 것보다, 집의 쓰레기통에 하나하나 모았다가, 
꽉 차면 한번에 밖에 버리는게 훨씬 효율적인 것과 비슷한 개념이라고 생각하면 된다.

```
#)Scanner
```
BufferedReader를 보기전에 먼저 Scanner를 살펴보자
대부분 Java를 처음배울때, Scanner를 통한 입출력을 먼저배우는데
Scanner는 띄어쓰기와 개행문자를 경계로 하여 입력값을 인식한다. 그래서 가공할 필요없이 편리하다.

가공할 필요가 없다는 뜻은, 가령 int형 변수를 입력받고자 하면, int x = scanner.nextInt()
```

#)BufferedReader
```
BufferedReader는 입력 받은 데이터가 String으로 고정되기 때문에 입력받은 데이터를 원하는 타입으로 가공하는 작업이필요하다.

Scanner는 지원해주는 메소드가 많고, 사용하기 쉽기 때문에 많이 사용하지만, 버퍼 사이즈가 1024 char이기 때문에
많은 입력을 필요로 할 경우에는 성능상 좋지 못한 결과를 불러온다.

Scanner와 달리 BufferedReader는 개행문자만 경계로 인식하고 입력받은 데이터가 String으로 고정된다. 
그렇기 때문에 따로 데이터를 가공해야하는 경우가 많다(형변환 및 split). 하지만 Scanner보다 속도가 빠르다!

BufferedRead와 Scanner의 속도 차이를 잘 보여주는 예시가 있어 가져와 보았다.

10,000,000개의 0~1023 범위의 정수를 한 줄씩 읽고, 
입력으로 받은 정수의 합을 출력하는 프로그램을 각각 BufferedReader와 Scanner로 구현할 때의 수행시간이다.

입력 방식	수행시간(초)
java.util.Scanner	6.068
java.io.BufferedReader	0.934

그리고 버퍼 사이즈도 Scanner가 1024 char인데 비해, 
BufferedReader는 8192 char(16,384byte) 이기 때문에 입력이 많을 때 BufferedReader가 유리하다.

또한 BufferedReader는 동기화 되기 때문에 멀티 쓰레드 환경에서 안전하고, Scanner는 동기화가 되지 않기 때문에 멀티 쓰레드 환경에서 안전하지 않다.


- BufferedReader 사용법
BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
String s = br.readLine();
int i = Integer.parseInt(br.readLine());
선언의 위의 사용법과 같이 하면된다.

입력은 readLine();이라는 메소드를 사용한다. 
String으로 리턴 값이 고정되어 있기 때문에, 다른 타입으로 입력을 받고자 한다면 반드시 형변환이 필요하다. 
그리고, 예외처리를 반드시 필요로 한다. readLine()시 마다 try/catch문으로 감싸주어도 되고, 
throws IOException 을 통한 예외처리를 해도 된다.(대부분의 경우에 후자를 사용한다.)

- 데이터 가공
BufferedReader를 통해 읽어온 데이터는 개행문자 단위(Line 단위)로 나누어진다. 
만약 이를 공백 단위로 데이터를 가공하고자 하면 따로 작업을 해주어야 한다. 
이때 사용하는 것이 StringTokenizer나 String.split() 함수이다.

// StringTokenizer 
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine());
int N = Integer.parseInt(st.nextToken());
int M = Integer.parseInt(st.nextToken());

// String.split() 함수
String arr[] = s.split(" ");
StringTokenizer의 nextToken() 함수를 쓰면 readLine()을 통해 입력 받은 값을 공백 단위로 구분하여 순서대로 호출할 수 있다.

String.split() 함수를 사용하면, 배열에 공백단위로 끊어 데이터를 저장하여 사용할 수 있다.
```

#)BufferedWriter
```
일반적으로 출력을 할때, System.out.println(""); 을 많이쓰는데
적은 양의 출력에서는 편리하고, 그렇게 큰 성능 차이 없이 사용할 수 있다. 하지만 우리가 늘 고려해야하는 경우는 양이 많을 경우이다. 
많은 양의 출력을 할 때는, 입력과 동일하게 버퍼를 사용하는 것이 좋다.

- BufferedWriter 사용법
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 선언
String str = "abcdef"; // 출력할 문자열
bw.write(s); // 출력
bw.newLine(); // 줄바꿈
bw.flush(); // 남아있는 데이터 모두 출력
bw.close();
BufferedWriter는 System.out.println(""); 처럼 출력과 개행을 동시해 해주지 않기 때문에, 개행을 위해선

따로 newLine(); 혹은 bw.write("\n");을 사용해야한다. 
그리고 BufferedWriter의 경우 버퍼를 잡아 놓았기 때문에 반드시 사용한 후에, 
flush()/ close()를 해주어야 한다. close()를 하게되면, 출력 스트림을 아예 닫아버리기 때문에 한번 출력후, 
다른 것도 출력하고자 한다면 flush()를 사용하면 된다.
```

#)StringBuilder
```
알고리즘 연습 문제를 풀다보면, BufferdReader/BufferedWriter만큼 StringBuilder도 많이 사용하는 것을 볼 수 있다.
그래서 이 StringBuiler는 무엇인지, String과 StringBuffer와의 차이점은 무엇인지 알아보자.

먼저, String과 StringBuffer/StringBuilder의 차이는

String은 불변속성을 갖고, StringBuffer/StringBuilder는 그렇지않다.


String이 불변성을 갖는 다는 의미는, concat이나 +  연산을 통해 값을 변경하면, 원래 기존의 String 메모리에서 값이 바뀌는 것이 아니라, 
기존의 String에 들어있던 값을 버리고 새로운 값을 재할당하게 된다. 처음에 할당한 String의 메모리 영역은 Garbage로 남아있다가 GarbageCollection)에 의해 없어진다.

//아래처럼 값을바꾸는게 메모리 재할당이 되는 것이다.
String a = "!@#$^&*()_+#'-=";
System.out.println(a.hashCode()); //1481914819
a="1234";	
System.out.println(a.hashCode()); //1509442

String은 불변성을 가지기 때문에 변하지 않는 문자열을 자주 읽어들이는 경우 사용하면 유리하다. 
하지만 문자열 추가, 삭제, 수정 등의 연산이 자주 일어나는 경우에 String을 사용하면, 
힙 메모리에 많은 Garbage가 생성되고, 이는 힙 메모리 부족으로 이어져 프로그램의 성능에 치명적 영향을 미칠 수 있다.

이를 해결하기 위해 나온 것이 StringBuffer/StringBuilder이다.

StringBuffer/StringBuilder는 가변성을 가지기 때문에, 
.append() , .delete()등 동일 객체 내에서 문자열을 변경하는 것이 가능하다. 
그렇게 때문에 문자열의 추가, 수정, 삭제가 빈번하게 발생할 경우 사용해야 한다.

아래의 사진은 문자열을 합치는 연산을 할 때의, 각각의 수행 시간을 보여주는 표이다.
String의 concat을 사용하면, 나머지 StringBuffer와 StringBuilder의 append() 보다 속도가 현저히 느린 것을 볼 수 있다.


- StringBuffer vs StringBuilder
StringBuffer : 동기화를 지원하여 멀티 쓰레드 환경에서 안전하다.
StringBuilder : 동기화를 지원하지 않아 멀티 쓰레드 환경에 사용하기 적합하지 않다. 대신, 동기화를 지원하지 않기에 단일쓰레드에서는 StringBuffer보다 성능이 뛰어나다.

정리하자면, StringBuilder는 문자열의 연산이 자주 일어나는 단일 쓰레드 환경에서 사용하는 것이 유리하다.
 
- StringBuilder 사용법
StringBuilder sb = new StringBuilder();
sb.append("a");
sb.append("b").append(" ");
sb.append("c").append("\n");
```
```
//스레드란 - 하나의 프로세스안에서 독립적으로 실행되는 '작은 실행 단위'를 의미한다.
게임할 때 움직이면서 총을 쏘고 싶다. 한번 움직이고 총을 쏘면 효율이 없다. 
총을 쏘면서 움직이도록 구현하기 위해 멀티 스레드를 이용하여 많은 양을 한번에 처리하도록 한다.

//스레드와 프로세스의 차이점
프로세스는 운영체제로부터 자원을 할당받는 작업 단위이다. 
애플리케이션이 하나의 프로세스가 되고, 그 안에서 여러 개의 스레드가 할당 받은 자원을 이용하여 실행 단위로 존재할 수 있다. 
즉 스레드는 하나의 프로세스 안에서 여러 실행의 흐름이라고 생각하면 된다.

//이게 멀티스레드
------process-----------
code	Data	Heap   |
Thread1--	  --Thread2|
 Stack	|	  |	 Stack |
---------     ---------|
-----------------------|

Thread.start()
- 스레드를 시작한다. 시작하면 run()이 수행된다.

Thread.run()
- 스레드 작업을 정의한다.

Thread.sleep(long millis)
- 현재스레드를 주어진 시간(밀리초)만큼 일시 중지한다.

public class ThreadSample extends Thread {

    @Override
    public void run() { //스레드 작업을 정의(run)
        System.out.println("스레드를 시작합니다.");
    }

    /**
     * Thread의 메인
     *
     * @param args
     */
    public static void main(String[] args) {
        ThreadSample sample = new ThreadSample();
        // 스레드를 시작합니다.
        sample.start();
    }
}

public class ThreadSample extends Thread {

    int seq;

    /**
     * 시퀀스를 정의 하는 생성자 구성
     *
     * @param seq
     */
    public ThreadSample(int seq) {
        this.seq = seq;
    }
	
    @Override
    public void run() {
        System.out.println(seq + "번째 스레드를 시작합니다.");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(seq + "번째 스레드를 종료합니다.");

    }

    /**
     * Thread의 메인
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            ThreadSample sample = new ThreadSample(i);
            // 스레드를 시작합니다.
            sample.start();
        }
        System.out.println("메인 메서드가 종료되었습니다.");
    }
}

1. 스레드는 반복문의 순차적으로 시작되지 않았습니다.
2. 스레드의 종료는 시작한 순서대로 종료하지 않았습니다.
3. 메인 메서드가 제일 먼저 종료가 되었습니다.

💡 해당 결과로 멀티 스레드는 순차적으로 시작되지 않고 순차적으로 종료되지 않는 점을 알게 되었습니다.
```
```
멀티쓰레딩은 하나의 프로세스 내에서 여러 쓰레드가 동시에 작업을 수행하는 것이 가능하다. 
실제로는 한 개의 CPU가 한 번에 단 한가지 작업만 수행할 수 있기 때문에 아주 짧은 시간 동안 여러 작업을 번갈아 가며 수행함으로써 
동시에 여러 작업이 수행되는 것처럼 보이게 하는 것이다. 

ex) 메신저의 경우 채팅하면서 파일을 다운로드 받거나 음성대화를 나눌 수 있는 것이 가능한 이유가 바로 멀티쓰레드로 작성되어 있기 때문이다.

//쓰레드를 구현하는 방법은 두가지가 있다.
1. Thread클래스를 상속받거나
2. Runnable 인터페이스를 구현하거나

Runnable 사용을 권장한다. (Thread클래스를 상속받으면 다른 클래스를 상속받지 못하기 때문에)
Runnable을 구현하는 방법은 재사용성이 높고 코드의 일관성을 유지 할 수 있다는 장점이 있기 때문에 보다 객체지향적인 방법이라 할 수 있다.

1. Thread클래스
public class ThreadExam01 {
   public static void main(String[] args){
       MyThread01 m1 = new MyThread01("*");
       MyThread01 m2 = new MyThread01("+");
       MyThread01 m3 = new MyThread01("#");
       m1.start();
       m2.start();
       m3.start();
       System.out.println("main메소드 종료.");
  }
}
​
class MyThread01 extends Thread{
   private String str;
   public MyThread01(String str){
       this.str = str;
  }
​
   @Override
   public void run() {
       for(int i = 0; i < 5; i++)
           System.out.print(str);
  }
}

2. Runnable 인터페이스
public class ThreadExam02 {
   public static void main(String[] args){
       Runnable r1 = new MyThread02("*"); //여기서이미 String str=*을 갖고있다.
       Runnable r2 = new MyThread02("%");
       Runnable r3 = new MyThread02("#");
       
       //Thread t1 = new Thread(new MyThread02("*"));
       Thread t1 = new Thread(r1);
       Thread t2 = new Thread(r2);
       Thread t3 = new Thread(r3);
       t1.start();
       t2.start();
       t3.start();
       System.out.println("main메소드 종료.");
  }
}
​
class MyThread02 implements Runnable{
   private String str;
   public MyThread02(String str){
       this.str = str;
  }
​
   @Override
   public void run() {
       for(int i = 0; i < 5; i++)
           System.out.print(str);
  }
}

[실행결과]
*****#####%%%%%main메소드 종료.(순차적으로 나온거는 컴터가 빨라서 이렇게 나올수도있다)


일단 둘 다 공통적으로 사용하기 위해서는
run() 메소드를 상속받아서 오버라이딩 해줘야한다. 
쓰레드 작업을 해줄 곳에 start()를 호출해준다.  
start()를 호출하면 thread를 실행 준비 -> run()을 실행한다.(템플릿 메서드 패턴 적용, 오버라이딩한 메소드 사용)


- run()에 Thread.sleep() 위코드를 수정하여 사용해서 지연
   @Override
   public void run() {
       for(int i = 0; i < 5; i++){
           System.out.print(str);
           try { //sleep을 이용
               Thread.sleep((long) (Math.random() * 1000));
          }catch(InterruptedException ie){}
      }
  }
[실행결과]
*#main메소드 종료.
%**#%*%*%#%##



```
