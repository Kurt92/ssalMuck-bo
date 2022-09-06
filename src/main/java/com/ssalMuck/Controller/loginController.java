package com.ssalMuck.Controller;

import com.ssalMuck.Dto.MemberDTO;
import com.ssalMuck.Entity.Member;
import com.ssalMuck.service.LoginService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
public class loginController {


    @Autowired LoginService loginService;


    @ApiOperation(value="로그인", notes="유저를 조회한다")

    @Transactional
    @GetMapping("/login.do")
    public ResponseEntity login(@ModelAttribute MemberDTO memberDto, HttpSession session){



        memberDto = loginService.login(memberDto);


        session.setAttribute("id",memberDto.getId());
        session.setAttribute("name",memberDto.getName());


        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("list", memberDto);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }

    @GetMapping("/logout.do")
    public ResponseEntity logout(HttpSession session){
        log.info("session check : "+session.getId());
        session.invalidate();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity signin() {
        return null;
    }



    /*private String fullPath(String fileName){
        return File.separator + "Users" + File.separator + "kurt" + File.separator + "test"+ File.separator + fileName;
    }*/
   /* @GetMapping("/hwp.do")
    @ApiOperation(value="한글파일", notes="한글파일 읽기 테스트")*/

  /*  public void hwp() throws Exception{
        String fileName = "test.hwp";
        System.out.println("한글파일 읽기 시작");
        System.out.println(fileName);
        try{
            System.out.println("경로확인 : " + fullPath(fileName));
            HWPFile hwpFile = HWPReader.fromFile(fullPath(fileName));
            if (hwpFile != null) {
                Section s = hwpFile.getBodyText().getSectionList().get(0);
                int count = s.getParagraphCount();
                System.out.println(count);
                for(int i=0; i<=count-1; i++) {
                    System.out.println(s.getParagraph(i).getText().getNormalString(0));
                }
*//*
            if (hwpFile.getBodyText().getSectionList().size() > 0) {
                System.out.println("===============================");
                System.out.println(fileName + "  읽기 성공 !!");

                String result = hwpFile.getBodyText().toString();
                System.out.println("ㅁㅁㅁㅁ : " + hwpFile.getBodyText());
                System.out.println("toString : " + result);

*//*

                *//*for (String text : result) {
                    System.out.println("\"필드A\"= " + text + result);
                }*//*

            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("===============================");
            System.out.println(fileName + "  읽기 실패 !!");
        }
    }*/

    /*private static void changeParagraphText(Paragraph paragraph) throws UnsupportedEncodingException {
        ArrayList<HWPChar> newCharList = getNewCharList(paragraph.getText().getCharList());
        changeNewCharList(paragraph, newCharList);
        removeLineSeg(paragraph);
        removeCharShapeExceptFirstOne(paragraph);
    }

    public static ArrayList<HWPChar> getNewCharList(ArrayList<HWPChar> oldList) throws UnsupportedEncodingException {
        ArrayList<HWPChar> newList = new ArrayList<HWPChar>();
        ArrayList<HWPChar> listForText = new ArrayList<HWPChar>();
        for (HWPChar ch : oldList) {
            if (ch.getType() == HWPCharType.Normal) {
                listForText.add(ch);
            } else {
                if (listForText.size() > 0) {
                    String text = toString(listForText);
                    listForText.clear();
                    String newText = changeText(text);

                    newList.addAll(toHWPCharList(newText));
                }
                newList.add(ch);
            }
        }

        if (listForText.size() > 0) {
            String text = toString(listForText);
            listForText.clear();
            String newText = changeText(text);

            newList.addAll(toHWPCharList(newText));
        }
        return newList;
    }

    private static String toString(ArrayList<HWPChar> listForText) throws UnsupportedEncodingException {
        StringBuffer sb = new StringBuffer();
        for (HWPChar ch : listForText) {
            HWPCharNormal chn = (HWPCharNormal) ch;
            sb.append(chn.getCh());
        }
        return sb.toString();
    }

    private static String changeText(String text) {
        if (source1.equals(text)) {
            return target1;
        } else if (source2.equals(text)) {
            return target2;
        }
        return null;
    }

    private static ArrayList<HWPChar> toHWPCharList(String text) {
        ArrayList<HWPChar> list = new ArrayList<HWPChar>();
        int count = text.length();
        for (int index = 0; index < count; index++) {
            HWPCharNormal chn = new HWPCharNormal();
            chn.setCode((short) text.codePointAt(index));
            list.add(chn);
        }
        return list;
    }

    private static void changeNewCharList(Paragraph paragraph, ArrayList<HWPChar> newCharList) {
        paragraph.getText().getCharList().clear();
        for (HWPChar ch : newCharList) {
            paragraph.getText().getCharList().add(ch);
        }
        paragraph.getHeader().setCharacterCount(newCharList.size());
    }

    private static void removeLineSeg(Paragraph paragraph) {
        paragraph.deleteLineSeg();
    }


    private static void removeCharShapeExceptFirstOne(Paragraph paragraph) {
        int size = paragraph.getCharShape().getPositonShapeIdPairList().size();
        if (size > 1) {
            for (int index = 0; index < size - 1; index++) {
                paragraph.getCharShape().getPositonShapeIdPairList().remove(1);
            }
            paragraph.getHeader().setCharShapeCount(1);
        }
    }*/
}
