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
		
		LottoBean param = new LottoBean();
		param.setBall(lotto2String(sort(lottomaker(6))));
		param.setLotteryNum(lotto2String(sort(lottomaker(6))));
		param.setLottoSeq(lottoSeq());
		
		dao.insertLotto(param);
		
	}
	
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
		return temp;
	}
	
	public String lotto2String (int[] param) {
		String result = "";
		
		for (int i = 0; i < param.length; i++) {
			result += (i<param.length-1)?  param[i] + ",": param[i];
		}
		return result;
	}
	
	public int[] sort(int[] param) {
		
		for (int i = 0; i < param.length-1; i++) {
			for (int j = i+1; j < param.length; j++) {
				if (param[i] > param[j]) {
					int temp = param[i];
					param[i] = param[j];
					param[j] = temp;
				}
			}
		}
		return param;
	}
	
	
}
