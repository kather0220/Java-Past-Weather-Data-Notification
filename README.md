# Java-Past-Weather-Data-Notification

과거 날씨 데이터 알리미

<어떤 프로젝트인가>

사용자가 과거의 날짜를 선택하면 해당 날짜의 날씨 데이터를 읽어와서 사용자에게 알려주는 프로그램입니다.

<구현 방법>

JFrame을 상속받은 클래스 내에 JComboBox를 이용하여 날짜를 입력 받는 박스를 구현합니다. 사용자가 입력한 날짜는 변수에 저장되도록 합니다.

날짜를 입력 받는 첫 화면을 JPanel을 이용하여 구현하고, 사용자가 날짜를 선택하고 선택 완료 버튼을 누르면 첫 화면의 JPanel 을 끄고 날씨를 알려주는 JPanel 을 띄우도록 합니다.

선택 완료 버튼을 누를 때, 날짜별 날씨 데이터를 가지고 있는 weather_data.csv 에 접근하여 데이터에 순차적으로 접근하면서 입력 받은 날짜와 같은 날짜를 찾습니다. 이 때, BufferedReader를 이용하여 줄 별로 데이터를 읽어와서 데이터들을 분리해주었습니다.

입력 받은 날짜에 해당하는 평균 기온, 최저 기온, 최고 기온 데이터를 가져옵니다. 평균 기온은 실수형으로 바꾸어서 변수에 저장합니다.

날씨를 알려주는 화면에서 Jlabel 을 이용하여 입력 받은 날짜, 평균 기온, 최저 기온, 최고 기온을 사용자에게 알려줍니다.

평균 기온에 따라 범위를 나누어, 해당 기온의 날씨가 어떤지를 그림과 함께 보여줍니다.

여러가지 예외들은 다양한 방식으로 처리해주었습니다. JComboBox가 입력되지 않았을 때 생길 에러를 방지하기 위하여 년도, 월, 일 에 각각의 초기값인 “2001”, “01”, “01＂을 저장해주었습니다. 또, 입력한 날짜가 존재하지 않는 날짜인 경우 ( ex. 2001년 2월 30일 )에는 화면을 바꾸지 않고, 기존 화면에 날짜를 다시 입력하라는 메시지를 출력했습니다. 그 외에 다른 에러들은 try-catch 문을 이용하여 처리해주었습니다.
