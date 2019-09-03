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
		dao= new LottoDaoImpl();
	}
	
	@Override
	public void createLotto(LottoBean lb) {
		int[] lotteryNums = new int[6];
		lotteryNums = lottomaker(6);
		int[] balls = new int[6];
		balls= lottomaker(6);
		
		
		LottoBean param = new LottoBean();
		param.setBall(lotto2String(balls));
		param.setLotteryNum(lotto2String(lotteryNums));
		param.setLottoSeq(lottoSeq());
		
		dao.insertLotto(param);
		
	}
//ottoSeq, ball, lotteryNum;
	public String lottoSeq() {
		Random rd = new Random();
		String result="";
		for (int i = 0; i <4; i++) {
			result += (rd.nextInt(10)+1);
		}
		return result;
	}
	
	
	public int[] lottomaker (int cnt) {
		
		int[] temp = new int[cnt];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = (int)(Math.random()*45+1);
			for (int j = 0; j < i; j++) {
				if (temp[j]== temp[i]) {
					i--;
					break;
				}				
			}
		}
		
		Arrays.sort(temp);
		return temp;
	}
	
	public String lotto2String (int[] param) {
		String result = "";
		
		for (int i = 0; i < param.length; i++) {
			result += (i<param.length-1)?  param[i] + ",": param[i];
		}
		return result;
	}
	
}
