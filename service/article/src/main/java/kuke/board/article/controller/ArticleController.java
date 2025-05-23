package kuke.board.article.controller;

import kuke.board.article.service.ArticleService;
import kuke.board.article.service.request.ArticleCreateRequest;
import kuke.board.article.service.request.ArticleUpdateRequest;
import kuke.board.article.service.response.ArticleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/v1/articles/{articleId}")
    public ArticleResponse read (@PathVariable Long articleId){
        return articleService.read(articleId);
    }
    @PostMapping("/v1/articles")
    public ArticleResponse create(@RequestBody ArticleCreateRequest request){
        return articleService.create(request);
    }
    @PutMapping("/v1/articles/{articeId}")
    public ArticleResponse update(@PathVariable Long articeId, @RequestBody ArticleUpdateRequest request) {
        return articleService.update(articeId, request);
    }

    @DeleteMapping("/v1/articles/{articeId}")
    public void delete(@PathVariable long articeId) {
        articleService.delete(articeId);
    }
}
