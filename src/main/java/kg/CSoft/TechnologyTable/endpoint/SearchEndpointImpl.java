package kg.CSoft.TechnologyTable.endpoint;

import kg.CSoft.TechnologyTable.dto.search.SearchDto;
import kg.CSoft.TechnologyTable.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchEndpointImpl implements SearchEndpoint {
    @Autowired
    private SearchService searchService;

    @Override
    public List<SearchDto> resultList(String search) {
        return SearchDto.toList(
                searchService.hostSearch(search),
                searchService.subNetworkSearch(search),
                searchService.projectSearch(search)
        );
    }
}
