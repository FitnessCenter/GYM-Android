# GYM-Android
Create DSM Gym App (feat. COVID-19)💥

## People
- 유재민, 윤석준

## Time
* 2020.07.22 ~ 2020.09.25

## Tech 

* MVP
* Rxjava2
* Android Jetpack
* koin
* Clean Architecture

![Clean Architecture](https://miro.medium.com/max/3780/1*FRgFgSG2mu4nRPyhwsPn3Q.png)

## Language 
* Kotlin

## Git Rule

* dev branch 에서 기능별로 feature 브랜치를 파서 각자 개발한다.
* 각자 기능이 완성 되면 pull request를 하여 코드 리뷰를 받은 후 수정 후 통과가 되면 dev branch에 merge한다.
* dev branch가 완성 되면 release branch를 만들어 테스트를 하고 문제가 없으면 master branch에 배포한다.

## Resource Rule
- color와 string은 전부 colors.xml, string.xml에서 관리한다.
- 네이밍은 다음과 같이 작성한다.
  - drawable은 what_description_where
  - Layout은 what_description
  - ID는 where_description_what, colors는 what
