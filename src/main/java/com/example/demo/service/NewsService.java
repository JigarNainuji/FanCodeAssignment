package com.example.demo.service;

import com.example.demo.entity.Match;
import com.example.demo.entity.News;
import com.example.demo.entity.Tour;
import com.example.demo.repository.MatchRepository;
import com.example.demo.repository.NewsRepository;
import com.example.demo.repository.TourRepository;
import com.example.demo.requestTO.NewsRequestTO;
import com.example.demo.responseTO.NewsResponseTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.Module;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.ValidationFailureException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NewsService {

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    MatchRepository matchRepository;

    @Autowired
    TourRepository tourRepository;

    public NewsResponseTO createNewsByMatchId(NewsRequestTO newsRequestTO) throws Exception {

        Match match = null;
        News news = null;
        NewsResponseTO newsResponseTO= null;
        try {
            if (newsRequestTO.getDescription() == null || newsRequestTO.getDescription().isEmpty()) {
                throw new ValidationFailureException("News description is null or empty! ");
            }
            if (newsRequestTO.getTitle() == null || newsRequestTO.getTitle().isEmpty()) {
                throw new ValidationFailureException("News title is null or empty!");
            }
            if (newsRequestTO.getTourIdOrMatchId() == null || newsRequestTO.getTourIdOrMatchId() <= 0) {
                throw new ValidationFailureException("MatchId is invalid!");
            }
            match = matchRepository.findById(newsRequestTO.getTourIdOrMatchId())
                    .orElseThrow(() -> new ValidationFailureException("MatchId is invalid!"));

            news = new News();
            news.setDescription(newsRequestTO.getDescription());
            news.setTitle(newsRequestTO.getTitle());
            news.setMatchId(match.getId());
            news.setTourId(match.getTourId());
            news.setSportId(match.getTour().getSportId());
            news.setCreatedAt(new Date());
            newsRepository.save(news);
            ModelMapper modelMapper = new ModelMapper();
            newsResponseTO = modelMapper.map(news,NewsResponseTO.class);

        } catch (ValidationFailureException vfe) {
            throw vfe;

        } catch (Exception e) {
            throw e;
        }
        return newsResponseTO;
    }

    public NewsResponseTO createNewsByTourId(NewsRequestTO newsRequestTO) throws Exception {

        Tour tour = null;
        News news = null;
        NewsResponseTO newsResponseTO = null;
        try {
            if (newsRequestTO.getDescription() == null || newsRequestTO.getDescription().isEmpty()) {
                throw new ValidationFailureException("News description is null or empty! ");
            }
            if (newsRequestTO.getTitle() == null || newsRequestTO.getTitle().isEmpty()) {
                throw new ValidationFailureException("News title is null or empty!");
            }
            if (newsRequestTO.getTourIdOrMatchId() == null || newsRequestTO.getTourIdOrMatchId() <= 0) {
                throw new ValidationFailureException("TourId is invalid!");
            }
            tour = tourRepository.findById(newsRequestTO.getTourIdOrMatchId())
                    .orElseThrow(() -> new ValidationFailureException("MatchId is invalid!"));

            news = new News();
            news.setDescription(newsRequestTO.getDescription());
            news.setTitle(newsRequestTO.getTitle());
            news.setMatchId(null);
            news.setTourId(tour.getId());
            news.setSportId(tour.getSportId());
            news.setCreatedAt(new Date());
            newsRepository.save(news);
            ModelMapper modelMapper = new ModelMapper();
            newsResponseTO = modelMapper.map(news,NewsResponseTO.class);
        } catch (ValidationFailureException vfe) {
            throw vfe;

        } catch (Exception e) {
            throw e;
        }
        return newsResponseTO;
    }

    public List<NewsResponseTO> getNewsByMatchId(Integer matchId)
    {
        List<NewsResponseTO> newsResponseTOList = null;
        try{
            if(matchId==null || matchId<=0)
            {
                throw new ValidationFailureException("matchId is invalid");
            }
            List<News> newsList = newsRepository.findAllNewsByMatchId(matchId);
            newsResponseTOList = new ArrayList<>();
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            for(News news:newsList)
            {
                newsResponseTOList.add(modelMapper.map(news,NewsResponseTO.class));
            }
        }catch (ValidationFailureException vfe)
        {
            throw vfe;
        }catch (Exception e)
        {
            throw e;
        }
        return newsResponseTOList;
    }

    public List<NewsResponseTO> getNewsByTourId(Integer tourId)
    {
        List<NewsResponseTO> newsResponseTOList = null;
        try{
            if(tourId==null || tourId<=0)
            {
                throw new ValidationFailureException("tourId is invalid");
            }
            List<News> newsList = newsRepository.findAllNewsByTourId(tourId);
            newsResponseTOList = new ArrayList<>();
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            for(News news:newsList)
            {
                newsResponseTOList.add(modelMapper.map(news,NewsResponseTO.class));
            }
        }catch (ValidationFailureException vfe)
        {
            throw vfe;
        }catch (Exception e)
        {
            throw e;
        }
        return newsResponseTOList;
    }

    public List<NewsResponseTO> getNewsBySportId(Integer sportId)
    {
        List<NewsResponseTO> newsResponseTOList = null;
        try{
            if(sportId==null || sportId<=0)
            {
                throw new ValidationFailureException("sportId is invalid");
            }
            List<News> newsList = newsRepository.findAllNewsBySportId(sportId);
            newsResponseTOList = new ArrayList<>();
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            for(News news:newsList)
            {
                newsResponseTOList.add(modelMapper.map(news,NewsResponseTO.class));
            }
        }catch (ValidationFailureException vfe)
        {
            throw vfe;
        }catch (Exception e)
        {
            throw e;
        }
        return newsResponseTOList;
    }

}
