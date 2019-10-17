import java.util.ArrayList;

public class study_log{

    static int search(){        // 정렬 생각 안나니까 그냥 삽입정렬 만들어서 쓰자. 퀵정렬 공부해야되는뎅... 흠..

        return 0;
    }


    public static void main(String[] args){
        int[] n = {39, 40, 41, 42, 43, 44, 82, 83, 84, 85}; // do while scanner 쓰면 입력 받을 수 있지만 계속 입력하기 귀찮아서 고정
        int tmp = 0; 
        int idxofR = 0;
        //int[] remainder = new int[100]; //n.length];        // 다른 자료구조로 바꾸면 동적 할당 가능. 일단 배열로 작성
// 어떻게 줄일 것인가?
        arrayList<Integer> remainder = new arrayList();
        int[] rem = new int[n.length];
        

        for(int i = 0; i < n.length; i++){
            tmp = n[i]%42;
            //remainder[tmp]++;
            remainder.add(i, tmp);
        }
        
        
        
    }
}

        //ArrayList 를 사용해서 하면 될 것 같지만 일단은 배열으로 작성
//        for(int x : n){ //익숙해질때 까지는 좀 보류하자, 그냥 temp = a[i] 이런 때 자주 사용되는 것 같은데
//            if(){                //만약 내부에서 같은 값이 발견된다면 해당 인덱스 지점에 값을 대입
//                remainder[i++]= x%42;
//            }                   //
//            else{               // 같은 값이 없는 수가 들어오려고 하면 새로운 열을 만들고 추가.
        // 서로 다른 나머지값을 저장
            