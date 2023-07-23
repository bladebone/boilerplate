package hjseo.boilerplate.sample.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface SampleMapper {

    Long get();
}
