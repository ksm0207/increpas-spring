package DI;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		// bean을 구현한 xml파일 위치 지정
		String configLocation = "classpath:applicationContext.xml";
		
		// 지정한 위치를 참고할 수 있도록 설정파일을 얻어오기.
		
		AbstractApplicationContext appContext = new GenericXmlApplicationContext(configLocation);
		System.out.println(appContext);
		MyDog mydog = (MyDog) appContext.getBean("myDog");
		mydog.dogNameInfo();
		mydog.dogAgeInfo();
		
	}
}
