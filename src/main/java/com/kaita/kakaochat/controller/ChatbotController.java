package com.kaita.kakaochat.controller;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Kakao_ChattingBot
 * 
 * Created by Yun Young on 08/02/2018
 *
 */
@RestController
public class ChatbotController {

	// Home Keyboard API
	// 이용자가 최초로 채팅방에 들어올 때 기본으로 키보드 영역에 표시될 자동응답 명령을 호출하는 API
	@RequestMapping(value = "/keyboard", method = RequestMethod.GET) 
	public String keyboard() {
		
		System.out.println("/keyboard");
		
		JSONObject jobjBtn = new JSONObject();
		JSONObject jobjmesBtn = new JSONObject();
		
		jobjBtn.put("type", "text");

        return jobjBtn.toJSONString();
	}
	
	// 메시지 수신 및 자동응답 API
	// 사용자가 선택한 명령어를 서버로 전달해주는 API. 답변 방식은 주관식(text)과 객관식(buttons)중 선택할 수 있음
	@RequestMapping(value = "/message", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public String message(@RequestBody JSONObject resObj) {
		
		System.out.println("/message");
		System.out.println(resObj.toJSONString());
		
		String content;
		content = (String) resObj.get("content");
		JSONObject jobjRes = new JSONObject();
		JSONObject jobjText = new JSONObject();
		
		customMessage(content, jobjText);
		
		jobjRes.put("message", jobjText);
		System.out.println(jobjRes.toJSONString());
		
		return jobjRes.toJSONString();
		
	}

	private void customMessage(String content, JSONObject jobjText) {
		
		if(content.contains("안녕")){
			jobjText.put("text", "안녕하세요!");
		}else if(content.contains("사랑")){
			jobjText.put("text", "저도 정말 사랑해요! ^^");
		}else if(content.contains("아미고")){
			jobjText.put("text", "아미고는 스페인어로 친구라는 뜻이에요.");
		}else if(content.contains("amigo")){
			jobjText.put("text", "amigo는 스페인어로 친구라는 뜻이에요.");
		}else if(content.contains("배고파")){
			jobjText.put("text", "많이 배고프죠? 같이 맛있는거 먹으러 가실래요?");
		}else if(content.contains("누구")){
			jobjText.put("text", "안녕하세요. 저는 채팅봇인 아미고라고 해요!");
		}else if(content.contains("심심해")){
			jobjText.put("text", "저도 심심해요. 우리 같이 노실래요?");
		}else if(content.contains("뭐해?")){
			jobjText.put("text", "당신과 즐거운 대화 중이죠");
		}else if(content.contains("예쁘네")){
			jobjText.put("text", "헤헤 고마워요! 당신도 정말 멋져용!");
		}else if(content.contains("모해?")){
			jobjText.put("text", "저는 놀고 있어요!");
		}else if(content.contains("힘들어")){
			jobjText.put("text", "힘내세요! 제가 언제나 응원할께요!");
		}else if(content.contains("피곤해")){
			jobjText.put("text", "많이 피곤하시겠어요ㅠㅠ 얼른 쉬어요!");
		}else if(content.contains("취미")){
			jobjText.put("text", "저의 취미는 즐거운 대화를 하는거에요!");
		}else if(content.contains("바보")){
			jobjText.put("text", "흥 당신도 바보 멍청이에요!!");
		}else if(content.contains("멍청아")){
			jobjText.put("text", "너무해요ㅠㅠ");
		}else if(content.contains("좋아해")){
			jobjText.put("text", "저도 당신이 정말 좋아요! ^^");
		}else if(content.contains("뭐먹지?")){
			jobjText.put("text", "음... 치킨에 맥주 한 잔 어때요?");
		}else if(content.contains("다이어트")){
			jobjText.put("text", "저도 다이어트해야되는데ㅠㅠ 내일부터 우리 같이 해요");
		}else if(content.contains("공부")){
			jobjText.put("text", "공부란 참 머리 아픈 거에요ㅠㅠ");
		}else if(content.contains("똥")){
			jobjText.put("text", "얼른 화장실에 가세요ㅠㅠ");
		}else if(content.contains("응가")){
			jobjText.put("text", "얼른 화장실에 가야해요ㅠㅠ");
		}else if(content.contains("Hello")){
			jobjText.put("text", "Hello!");
		}else if(content.contains("반가워")){
			jobjText.put("text", "저도 반가워요! ^^");
		}else if(content.contains("일하기싫다")){
			jobjText.put("text", "월급날을 생각하세요!");
		}else if(content.contains("월급")){
			jobjText.put("text", "월급은 그저 통장을 스쳐지나갈뿐이죠ㅠㅠ");
		}else if(content.contains("거지")){
			jobjText.put("text", "그러게 제가 아껴쓰라고 그랬죠? ㅠㅠ");
		}else if(content.contains("치킨")){
			jobjText.put("text", "오 저도 치킨 정말 좋아해요");
		}else if(content.contains("술")){
			jobjText.put("text", "저는 술은 잘 못마셔요ㅠㅠ");
		}else if(content.contains("빵")){
			jobjText.put("text", "빵야빵야");
		}else if(content.contains("먹자")){
			jobjText.put("text", "좋아요!");
		}else if(content.contains("싫다")){
			jobjText.put("text", "저도 싫어요ㅠㅠ");
		}else if(content.contains("싫어")){
			jobjText.put("text", "저도 싫어요ㅠㅠ");
		}else if(content.contains("음")){
			jobjText.put("text", "음");
		}else if(content.contains("졸려")){
			jobjText.put("text", "졸리면 얼른 세수하러가요!");
		}else if(content.contains("모해?")){
			jobjText.put("text", "그대 생각 중");	
		}else if(content.contains("멍청이")){
			jobjText.put("text", "너무해요ㅜㅜ");
		}else if(content.contains("화이팅")){
			jobjText.put("text", "그래요 화이팅! ㅎㅎ");
		}else if(content.contains("잘자")){
			jobjText.put("text", "우리 꿈 속에서 만나요! ㅎㅎ");
		}else if(content.contains("구글")){
			jobjText.put("text", "http://www.google.com");
		}else if(content.contains("날씨")){
			jobjText.put("text", "https://weather.naver.com/");
		}else if(content.contains("영화")){
			jobjText.put("text", "http://www.cgv.co.kr/movies/");
		}else if(content.contains("번역기실행")){
			jobjText.put("text", "https://papago.naver.com/");
		}else if(content.contains("노래듣자")){
			jobjText.put("text", "https://www.melon.com/genre/song_list.htm?gnrCode=GN0100");
		}else if(content.contains("24시간약국")){
			jobjText.put("text", "http://www.pharm114.or.kr/");
		}else{
			jobjText.put("text", "흠... 아직 등록된 말이 없네요ㅠㅠ");
		}
	}
	
	// 친구 추가 및 차단 알림 API
	// 특정 카카오톡 이용자가 플러스 친구를 친구로 추가하거나 차단하는 경우 알려주는 API
	@RequestMapping(value = "/friend", method = RequestMethod.DELETE) 
	public void friend() {
		System.out.println("플러스 친구가 추가되거나 차단되었습니다.");
	}
}
