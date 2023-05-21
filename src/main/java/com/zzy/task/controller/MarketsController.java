package com.zzy.task.controller;

import com.zzy.task.controller.dto.Market;
import com.zzy.task.controller.dto.Participant;
import com.zzy.task.controller.dto.Selection;
import com.zzy.task.service.MarketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("markets")
public class MarketsController {

    private final MarketsService marketsService;

    @Autowired
    public MarketsController(MarketsService marketsService) {
        this.marketsService = marketsService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Market> findAllMarkets() {
        List<Market> marketsList = marketsService.findAllMarkets();
        return marketsList;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Market findMarketById(@PathVariable("id") Long id) {
        return marketsService.findMarketById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Market addMarket(@Valid @RequestBody Market market) {
        return marketsService.addMarket(market);
    }

    @PostMapping(value = "/{id}/Participant", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Participant addParticipantToMarket(@Valid @PathVariable("id") Long id, @Valid @RequestBody Participant participant) {
        return marketsService.addParticipantToMarket(id, participant);
    }

    @PostMapping(value = "/{id}/Selection", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Selection addSelectionToMarkets(@Valid @PathVariable("id") Long id, @Valid @RequestBody Selection selection) {
        return marketsService.addSelectionToMarkets(id, selection);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String removeMarket(@PathVariable("id") Long id) {
        return marketsService.removeMarket(id);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Market updateMarket(@Valid @RequestBody Market market) {
        return marketsService.updateMarket(market);
    }
}
