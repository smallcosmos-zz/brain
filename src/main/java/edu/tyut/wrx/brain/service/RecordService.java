package edu.tyut.wrx.brain.service;

import edu.tyut.wrx.brain.model.Record;
import edu.tyut.wrx.brain.model.ResultVO;

public interface RecordService {

    ResultVO addRecordToDb(Record record);
}
