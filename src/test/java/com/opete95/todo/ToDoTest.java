package com.opete95.todo;

import com.opete95.todo.entity.ToDo;
import com.opete95.todo.persistence.ToDoRepository;
import com.opete95.todo.service.ToDoService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ToDoTest {
    @Autowired
    private ToDoRepository toDoRepository;

    //데이터 삽입 테스트
//    @Test
    public void insertTest(){
        ToDo todo1 = ToDo.builder()
                .userId("opete95")
                .title("커피숍 가기")
                .build();
        toDoRepository.save(todo1);
        ToDo todo2 = ToDo.builder()
                .userId("opete95")
                .title("편의점 가기")
                .build();
        toDoRepository.save(todo2);
    }

    //유저 아이디를 이용한 조회
//    @Test
//    @Disabled
    public void testFindUserId() {
        List<ToDo> list =
                toDoRepository.findByUserId("opete95");
        for (ToDo toDo : list) {
            System.out.println(toDo);
        }
        list.stream(). forEach(toDo->{
            System.out.println(toDo);
        });
    }

    //id에 해당하는 하나의 데이터 조회
    //데이터베이스에서 id를 조회해서 테스트
//    @Test
    public void testDetail(){
        Optional<ToDo> result =
                toDoRepository.findById(
                        "4028815283f38afe0183f38b09840001"
                );
        if(result.isPresent()){
            System.out.println(result.get());
        }
        else {
            System.out.println("데이터가 존재하지 않습니다.");
        }
    }
    //데이터 수정
//    @Test
    public void testUpdate(){
        ToDo todo = ToDo.builder()
                .id("4028815283f38afe0183f38b09840000")
                .userId("opete95")
                .title("지하철역 가기")
                .done(true)
                .build();
        toDoRepository.save(todo);

    }

    //데이터 삭제
//    @Test
//    @Disabled
    public void testDelete(){
        toDoRepository.deleteById(
                    "4028815283f38afe0183f38b09840000");
    }

    @Autowired
    private ToDoService toDoService;

    //삽입 테스트
    public void testServiceInsert(){
        ToDo toDo = ToDo.builder()
                .userId("opete95")
                .title("서비스 테스트")
                .done(false)
                .build();
        List<ToDo> list = toDoService.create(toDo);
        System.out.println(list);

    }

    //삽입 테스트
//    @Test
    public void testServiceRetrive(){
        List<ToDo> list =
                toDoService.retrieve("opete95");
        System.out.println(list);
    }

//    @Test
//    @Disabled
    public void testServiceUpdate(){
        ToDo toDo = ToDo.builder()
                .id("4028815283f38afe0183f38b09840000")
                .userId("opete95")
                .title("수정")
                .done(true)
                .build();
        List<ToDo> list = toDoService.update(toDo);
        System.out.println(list);

    }

    @Test
//    @Disabled
    public void testServiceDelete(){
        ToDo toDo = ToDo.builder()
                .id("4028815283f38afe0183f38b09840000")
                .userId("opete95")
                .build();
        List<ToDo> list = toDoService.delete(toDo);
        System.out.println(list);

    }
}
