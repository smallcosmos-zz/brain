package edu.tyut.wrx.brain.service;

import edu.tyut.wrx.brain.model.Record;
import edu.tyut.wrx.brain.model.RecordDTO;
import edu.tyut.wrx.brain.model.ResultVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface RecordService {

    ResultVO addRecordToDb(Record record);

    List<RecordDTO> getAllRecord(HttpServletRequest request);

    RecordDTO getRecordByUserId(String userId, HttpServletRequest request);
}
