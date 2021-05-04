package edu.tyut.wrx.brain.dao;

import edu.tyut.wrx.brain.model.Record;
import edu.tyut.wrx.brain.model.RecordDTO;
import edu.tyut.wrx.brain.model.gameAndScore;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecordMapper {
    void insertRecord(Record record);

    Record selectRecord(Record record);

    void deleteRecord(Record record);

    List<RecordDTO> getAllRecord(@Param("orgId") Integer orgId);

    List<gameAndScore> getGameAndScoreByUserId(@Param("userId") String id);

    RecordDTO getRecordByUserId(@Param("userId") String userId, @Param("orgId") Integer orgId);
}
