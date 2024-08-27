package inflearn2.a_simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpGetWithHeaderExample {

    public static void main(String[] args) {
        try {
            // 요청을 보낼 URL 설정
            URL url = new URL("https://smartstore.naver.com/osungmedical/products/5387492062");

            // URL로 연결 열기
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // GET 요청 설정
            connection.setRequestMethod("GET");

            // 요청 헤더 추가
            connection.setRequestProperty("Host", "smartstore.naver.com");
            connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
            connection.setRequestProperty("Sec-ch-ua" , "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.3");
            connection.setRequestProperty("User-agent", "\"Not)A;Brand\";v=\"99\", \"Google Chrome\";v=\"127\", \"Chromium\";v=\"127\"");
            connection.setRequestProperty("Cookie", "NNB=2VFLIZSUETFWK; _fwb=81LlFf08O9cvrwP2JBzcH9.1707814181276; SHP_BUCKET_ID=2; NaverSuggestUse=use%26unuse; ASID=3d4aba470000018dab6a3ee10000005f; NAC=Gct8BMAIJwjE; _ga_8P4PY65YZ2=GS1.1.1718082392.1.1.1718082392.60.0.0; ba.uuid=11533fb9-3d40-42ad-b1f3-9a0e7e5c85f7; OEP_BUCKET_ID=4; _ga=GA1.2.1873697495.1710420165; ncpa=6194384|dfc385b8485546f2e42913b1503006733cf06515|m00mos8g|s_282b15821a72|c921d49e5b2493ab8a0c73bb52debb25dc51f8c1:8617034|01c3e287850af748715bdbd2e9093e0a6dba0ca7|m00mvzhs|s_f44d562859d6|bf53c5a668b0734283c53ea68b15583f017f6398:1258289|m00mwexc|15311b64dc26c380d91ae2239916ce490f0b86fe|s_2b5972b06e1fb|562f232e5973403a0cf3107381c413817fd6c764:11249435|m03hcatc|53c25173b1900dcfda9492f51a2f4bc4ba2c4374|s_26f68849053e8|22666a8053e49e4bc7ab04e470d153ff052202fe:9199634|m03hgl4w|2532af84ba503fd6c4298ca20e2330e572ff1d12|s_ce2fb4fc9af|10c5bbe9b5b7e76074fce3481472e13c12470db8:10177004|m03hgmog|599c245c70516c40e47cd0b63389586ff39ffd40|s_13411b955f66|8103e454b5ade6883a8a37eabd1361a3d80cfafe:10594734|m03hgo80|c380490b2cf1e0dc30f80a6372a6d75978e18a23|s_1f140f87f483|c275aba954a0c1bdfe1f80b407a2e299885e56fa:1067290|m03hh240|76044e51f8ae00206aa5a86ecb3bfdafc32e9820|s_8f57825ce2e|03862bb47b398827e8667858932967eb1defb878:1075959|m03nr154|52b6575d8c570da2ce3152ea61a7251d50108096|s_2470fa248c4f8|4cbb8c1d3663c5bcd9de6ac40fce099ba7014f3b:95694|m04wzjoo|09654f7f6bb66dcccc7c48b86ee4d468a9832934|95694|41456dbc56f9b3be953a76315b126cb482f3dac4; NACT=1; X-Tx-Id=07db2afb-f6a4-4c18-8af8-b5b79896defa; sus_val=5OwRoQ0tLpNjN10PvQeYYk/H; BUC=GnbnEIrsZQRSuSP9M4hpt60PapkC2R_fSQFpLdcu6jQ=");

            // 응답 코드 확인
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // 응답이 200 OK일 경우 응답 내용 읽기
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                // 스트림 닫기
                in.close();

                // 응답 출력
                System.out.println(response.toString());
            } else {
                System.out.println("GET 요청 실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
