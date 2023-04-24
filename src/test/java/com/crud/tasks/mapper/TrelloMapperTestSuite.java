package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class TrelloMapperTestSuite {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    void testMapToList(){
        //given
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "listDto1", false);
        List<TrelloListDto> listDto = new ArrayList<>();
        listDto.add(trelloListDto1);
        //when
        List<TrelloList> resultTrelloList = trelloMapper.mapToList(listDto);
        //then
        assertEquals(1, resultTrelloList.size());
        assertEquals("listDto1", resultTrelloList.get(0).getName());
    }

    @Test
    void testMapToListDto(){
        //given
        TrelloList trelloList1 = new TrelloList("l1", "list1", false);
        List<TrelloList> list = new ArrayList<>();
        list.add(trelloList1);
        //when
        List<TrelloListDto> resultTrelloList = trelloMapper.mapToListDto(list);
        //then
        assertEquals(1, resultTrelloList.size());
        assertEquals("list1", resultTrelloList.get(0).getName());
    }

    @Test
    void testMapToBoards(){
        //given
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "listDto1", false);
        List<TrelloListDto> listDto = new ArrayList<>();
        listDto.add(trelloListDto1);
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("board1", "1", listDto);
        List<TrelloBoardDto> listTrelloBoard = new ArrayList<>();
        listTrelloBoard.add(trelloBoardDto1);
        //when
        List<TrelloBoard> resultTrelloBoard = trelloMapper.mapToBoards(listTrelloBoard);
        //then
        assertEquals(1, resultTrelloBoard.size());
        assertEquals("board1", resultTrelloBoard.get(0).getName());
    }

    @Test
    void testMapToBoardsDto(){
        //given
        TrelloList trelloList1 = new TrelloList("100", "list100", false);
        List<TrelloList> list = new ArrayList<>();
        list.add(trelloList1);
        TrelloBoard trelloBoard1 = new TrelloBoard("100", "board100", list);
        List<TrelloBoard> listTrelloBoard = new ArrayList<>();
        listTrelloBoard.add(trelloBoard1);
        //when
        List<TrelloBoardDto> resultTrelloBoard = trelloMapper.mapToBoardsDto(listTrelloBoard);
        //then
        assertEquals(1, resultTrelloBoard.size());
        assertEquals("board100", resultTrelloBoard.get(0).getName());
    }

    @Test
    void testMapToCard(){
        //given
        TrelloCardDto trelloCardDto = new TrelloCardDto("card1", "Card number 1", "001", "01");
        //when
        TrelloCard resultCard = trelloMapper.mapToCard(trelloCardDto);
        //then
        assertEquals("card1", resultCard.getName());
        assertEquals("001", resultCard.getPos());
    }

    @Test
    void testMapToCardDto(){
        //given
        TrelloCard trelloCard = new TrelloCard("card23", "Card number 23", "023", "23");
        //when
        TrelloCardDto resultCard = trelloMapper.mapToCardDto(trelloCard);
        //then
        assertEquals("card23", resultCard.getName());
        assertEquals("023", resultCard.getPos());
    }
}
