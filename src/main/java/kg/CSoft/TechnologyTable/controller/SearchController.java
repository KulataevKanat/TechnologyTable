package kg.CSoft.TechnologyTable.controller;

import kg.CSoft.TechnologyTable.dto.search.SearchDto;
import kg.CSoft.TechnologyTable.endpoint.search.SearchEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {
    @Autowired
    private SearchEndpoint searchEndpoint;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SearchDto> search(@RequestParam String search) {
        return searchEndpoint.resultList(search);
    }
}
