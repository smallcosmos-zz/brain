package edu.tyut.wrx.brain.dao;

import edu.tyut.wrx.brain.model.Record;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecordMapper {
    void insertRecord(Record record);

    Record selectRecord(Record record);

    void deleteRecord(Record record);
}
