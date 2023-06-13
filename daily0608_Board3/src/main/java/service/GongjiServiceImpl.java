package service;

import dao.GongjiDao;
import dao.GongjiDaoImpl;
import dto.Pagination;

public class GongjiServiceImpl implements GongjiService {
	@Override
	public Pagination getPagination(int page, int countPerPage) {// 사용자 입력하는 페이지 , 한페이지 출력할 갯수 파라미터
		Pagination pagination = new Pagination();// 반환할 페이지 객체 선언 및 초기화

		GongjiDao gongjiDao = new GongjiDaoImpl();// 다오를 import

		int totalData = gongjiDao.count();// 전체 데이터 갯수를 구해오는 메소드를 사용하여 변수에 저장

		// 마지막 페이지 값 구하기 => nn
		// 마지막 페이지 번호를 계산하여 변수에 저장하는데,
		// 전체 데이터 수(totalData)를 한 페이지당 출력할 데이터 수(countPerPage)로 나눈 나머지가 0인 경우,
		// 전체 데이터 수를 한 페이지당 출력할 데이터 수로 나눈 몫을 마지막 페이지 번호로 설정합니다.
		// 그렇지 않은 경우, 전체 데이터 수를 한 페이지당 출력할 데이터 수로 나눈 몫에 1을 더한 값을 마지막 페이지 번호로 설정합니다.
		int lastnumber = totalData % countPerPage == 0 ? totalData / countPerPage : ((totalData / countPerPage) + 1);

		int currentPage = 0; // 현재 페이지를 나타내는 변수 => 'c'
		if (page <= 0) { // 입력받은 페이지 값이 0보다 작은 경우
			currentPage = 1; // 현재 페이지를 1로 설정
		} else if (page > lastnumber) { // 입력받은 페이지 번호가 마지막 페이지 번호보다 클 경우
			currentPage = lastnumber; // 현재 페이지를 마지막 페이지 번호로 설정
		} else {
			currentPage = page; // 현재 페이지를 입력받은 페이지 값으로 설정
		}

		int startblock = ((currentPage - 1) / 10) * 10 + 1; // 버튼 시작 숫자를 계산하여 변수에 저장 => 's'

		int lastpageStart = ((lastnumber - 1) / 10) * 10 + 1; // 마지막 페이지 시작 버튼 숫자를 계산하여 변수에 저장 => 's1'

		int endblock = (startblock + 10) - 1; // 버튼 마지막 숫자를 계산하여 변수에 저장 => 'e'
		if (endblock > lastnumber) {
			endblock = lastnumber; // 버튼 마지막 숫자가 마지막 페이지 번호보다 크면 버튼 마지막 숫자를 마지막 페이지 번호로 설정
		}

		int p = currentPage - 10; // 이전 버튼의 값 계산하여 변수에 저장 => '<'
		if (p > 0) {
			p = currentPage - 10; // 이전 버튼의 값이 0보다 크면 변수에 설정
		} else {
			p = -1; // 이전 버튼의 값이 0보다 작거나 같으면 -1로 설정
		}

		int pp = currentPage - 10; // 맨 처음으로 가는 버튼의 값 계산하여 변수에 저장 => '<<'
		if (pp <= 0) {
			pp = -1; // 맨 처음으로 가는 버튼의 값이 0보다 작거나 같으면 -1로 설정
		} else {
			pp = 1; // 맨 처음으로 가는 버튼의 값이 0보다 크면 1로 설정
		}

		int n = 0; // 현재 페이지 + 10 값을 나타내는 변수 => '>'
		if (currentPage + 10 > lastnumber) {
			n = lastnumber; // 현재 페이지 + 10 값이 마지막 페이지 번호보다 크면 변수를 마지막 페이지 번호로 설정
		} else {
			n = currentPage + 10; // 현재 페이지 + 10 값이 마지막 페이지 번호보다 작거나 같으면 변수를 현재 페이지 + 10 값으로 설정
		}

		int nn = 0; // 맨 마지막 페이지 버튼의 값 계산하여 변수에 저장 => '>>'
		if (startblock >= lastpageStart) {
			n = -1;
			nn = -1; // 버튼 시작 숫자가 마지막 페이지 시작 버튼 숫자보다 크거나 같으면 -1로 설정
		} else {
			nn = lastnumber; // 버튼 시작 숫자가 마지막 페이지 시작 버튼 숫자보다 작으면 변수를 마지막 페이지 번호로 설정
		}

		pagination.setC(currentPage); // 현재 페이지 값을 Pagination 객체의 'C' 변수에 설정
		pagination.setS(startblock); // 버튼 시작 숫자 값을 Pagination 객체의 'S' 변수에 설정
		pagination.setE(endblock); // 버튼 마지막 숫자 값을 Pagination 객체의 'E' 변수에 설정
		pagination.setP(p); // 이전 버튼 '<'에 해당하는 값인 'p'를 Pagination 객체의 'P' 변수에 설정
		pagination.setPp(pp); // 맨 처음으로 가는 버튼 '<<'에 해당하는 값인 'pp'를 Pagination 객체의 'Pp' 변수에 설정
		pagination.setN(n); // 현재 페이지에서 10을 더한 값인 'n'을 Pagination 객체의 'N' 변수에 설정
		pagination.setNn(nn); // 맨 마지막 페이지 버튼 '>>'에 해당하는 값인 'nn'을 Pagination 객체의 'Nn' 변수에 설정

		return pagination;// 만들어진 페이지 객체 반환
	}
}
