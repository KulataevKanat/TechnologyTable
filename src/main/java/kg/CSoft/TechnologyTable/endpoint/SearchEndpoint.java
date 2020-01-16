package kg.CSoft.TechnologyTable.endpoint;

import kg.CSoft.TechnologyTable.dto.search.SearchDto;

import java.util.List;

public interface SearchEndpoint {
    List<SearchDto> resultList(String search);
}
