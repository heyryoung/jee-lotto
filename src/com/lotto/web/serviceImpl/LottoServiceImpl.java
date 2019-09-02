package com.lotto.web.serviceImpl;

import java.util.Arrays;
import java.util.Random;

import com.lotto.web.daoImpls.LottoDaoImpl;
import com.lotto.web.daos.LottoDao;
import com.lotto.web.domains.LottoBean;
import com.lotto.web.services.LottoServiece;

public class LottoServiceImpl implements LottoServiece {

	private LottoDao dao;
	
	public LottoServiceImpl() {
		dao = new LottoDaoImpl();
	}
	//lottoSeq < 일련번호, ball < (랜덤1~45번) , lotteryNum < 당첨번호 
	@Override
	public void createLotto(LottoBean pr) {
		LottoBean param = new LottoBean();
		
		String ball ="", lottoSeq="",lotteryNum="";
		Random rd = new Random();
		
		//lottoSeq
		for (int i = 0; i < 4; i++) {
			lottoSeq += String.valueOf(rd.nextInt(10));
		}
		
		//lotteryNum , ball 생
		int[] lotteryNums= new int[6];
		lotteryNums = lottomaker(6);
		
		int[] balls= new int[6];
		balls = lottomaker(6);		
		
		//콤마찍기
		lotteryNum = lotto2string(lotteryNums);
		ball = lotto2string(balls);
		
		param.setLottoSeq(lottoSeq);
		param.setBall(ball);
		param.setLotteryNum(lotteryNum);
		
		dao.inertLotto(param);
	}

	//중복 제거 로또 만들기
	public int[] lottomaker(int cnt) {
		
		int[] temp = new int[cnt]; 
		for (int i = 0; i < temp.length; i++) {
			temp[i] = (int)(Math.random()*45)+1; 
			for(int j=0; j<i; j++){	
				if(temp[i]==temp[j]){
					i--;
					break;
				}
			}
		}
		Arrays.sort(temp);  // sort
		return temp;
	}
	
	// 로또 번호 스트링으로 변환
	public String lotto2string(int[] param) {
		String result = "";
		for (int j = 0; j < param.length; j++) {
			result += (j<(param.length-1)) ?   param[j] + ",": param[j];
		}
		return result;
	}
	
}
