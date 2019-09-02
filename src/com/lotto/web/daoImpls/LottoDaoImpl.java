package com.lotto.web.daoImpls;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import com.lotto.web.daos.LottoDao;
import com.lotto.web.domains.LottoBean;

public class LottoDaoImpl implements LottoDao{

	public static final String FILE_PATH = String.format("C:%sUsers%suser%seclipse-jee%sjee-lotto%sWebContent%sresources%stxt%s",
			File.separator,
			File.separator,
			File.separator,
			File.separator,
			File.separator,
			File.separator,
			File.separator,
			File.separator);

	
	
	//lottoSeq < 일련번호, ball < (랜덤1~45번) , lotteryNum < 당첨번호 
	@Override
	public void inertLotto(LottoBean param) {
		
		try {
			File file = new File(FILE_PATH+"lotto.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
			writer.write(String.format("NO.%s/%s/%s", param.getLottoSeq(),param.getBall(),param.getLotteryNum()));
			writer.newLine();
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}


	
}
