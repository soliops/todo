package com.opete95.todo.controller;

import com.opete95.todo.domain.ResponseDTO;
import com.opete95.todo.domain.ToDoDTO;
import com.opete95.todo.entity.ToDo;
import com.opete95.todo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("todo")
public class ToDoController {
    private final ToDoService toDoService;

    //데이터 삽입
    //http://localhost/todo에 POST 방식으로 title만 설정
    @PostMapping
    public ResponseEntity<?> createToDo(
            @RequestBody ToDoDTO dto){
        try{
            //가상의 USER-ID 생성
            String temporaryUserId =
                    "opete95";
            //Entity 생성
            ToDo toDo = ToDoDTO.toEntity(dto);
            toDo.setUserId(temporaryUserId);
            //데이터 생성
            List<ToDo> entities = toDoService.create(toDo);
            //ToDo를 ToDoDTO로 변환
            //ToDoDTO의 생성자를 이용해서 변환한 후
            //List로 만들어주기
            List<ToDoDTO> dtos =
                    entities.stream().map(ToDoDTO::new)
                            .collect(Collectors.toList());
            //응답 객체 생성
            ResponseDTO<ToDoDTO> response =
            ResponseDTO.<ToDoDTO>builder()
                    .data(dtos).build();
            return ResponseEntity.ok().body(response);
        }catch (Exception e){
            String error = e.getMessage();
            ResponseDTO<ToDoDTO> response =
                    ResponseDTO.<ToDoDTO>builder()
                            .error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
    //ID로 조회
    @GetMapping
    public ResponseEntity<?> retriveToDoList(){
        String temporaryUserId = "opete95";
        //임시 ID로 데이터 찾아오기
        List<ToDo> entities =
                toDoService.retrieve(temporaryUserId);
        //찾아온 데이터를 이용해서 DTO의 List 만들기
        List<ToDoDTO> dtos =
                entities.stream().map(ToDoDTO::new)
                        .collect(Collectors.toList());
        //응답 객체 생성
        ResponseDTO<ToDoDTO> response =
                ResponseDTO.<ToDoDTO>builder()
                        .data(dtos).build();
        //클라이언트에게 전송
        return ResponseEntity.ok().body(response);
    }
    
    //데이터 수정
    //http://localhost/todo에 PUT방식으로 id,title,done 설정
    @PutMapping
    public ResponseEntity<?> updateToDoList(
        @RequestBody ToDoDTO dto){
            try{
                //가상의 USER-ID 생성
                String temporaryUserId =
                        "opete95";
                //Entity 생성
                ToDo toDo = ToDoDTO.toEntity(dto);
                toDo.setUserId(temporaryUserId);
                //데이터 생성
                List<ToDo> entities = toDoService.update(toDo);
                //ToDo를 ToDoDTO로 변환
                //ToDoDTO의 생성자를 이용해서 변환한 후
                //List로 만들어주기
                List<ToDoDTO> dtos =
                        entities.stream().map(ToDoDTO::new)
                                .collect(Collectors.toList());
                //응답 객체 생성
                ResponseDTO<ToDoDTO> response =
                        ResponseDTO.<ToDoDTO>builder()
                                .data(dtos).build();
                return ResponseEntity.ok().body(response);
            }catch (Exception e){
                String error = e.getMessage();
                ResponseDTO<ToDoDTO> response =
                        ResponseDTO.<ToDoDTO>builder()
                                .error(error).build();
                return ResponseEntity.badRequest().body(response);
            }
        }
    @DeleteMapping
    public ResponseEntity<?> deleteToDo(
            @RequestBody ToDoDTO dto){
        try{
            //가상의 USER-ID 생성
            String temporaryUserId =
                    "temporary-user";
            //Entity 생성
            ToDo toDo = ToDoDTO.toEntity(dto);
            toDo.setUserId(temporaryUserId);
            //데이터 생성
            List<ToDo> entities = toDoService.delete(toDo);
            //ToDo를 ToDoDTO로 변환
            //ToDoDTO의 생성자를 이용해서 변환한 후
            //List로 만들어주기
            List<ToDoDTO> dtos =
                    entities.stream().map(ToDoDTO::new)
                            .collect(Collectors.toList());
            //응답 객체 생성
            ResponseDTO<ToDoDTO> response =
                    ResponseDTO.<ToDoDTO>builder()
                            .data(dtos).build();
            return ResponseEntity.ok().body(response);
        }catch (Exception e){
            String error = e.getMessage();
            ResponseDTO<ToDoDTO> response =
                    ResponseDTO.<ToDoDTO>builder()
                            .error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
}
