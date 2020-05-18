package com.ssuriyan.hoa.hoaseriesservice.service;

import com.ssuriyan.hoa.hoaseriesservice.dto.ArcDTO;
import com.ssuriyan.hoa.hoaseriesservice.dto.EpisodeDTO;
import com.ssuriyan.hoa.hoaseriesservice.model.Anime;
import com.ssuriyan.hoa.hoaseriesservice.model.Arc;
import com.ssuriyan.hoa.hoaseriesservice.model.Episode;
import com.ssuriyan.hoa.hoaseriesservice.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EpisodeService {

    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private ArcService arcService;

    @Autowired
    private AnimeService animeService;

    public ResponseEntity<EpisodeDTO> insertEpisode(Episode episode) {

        /*RequestStatus requestStatus;
        Episode savedEpisode = null;
        Arc arc = arcService.getOne(episode.getArc().getId());

        if ((savedEpisode = episodeRepository.getByEpisodeNumber(episode.getEpisodeNumber())) != null) {
            requestStatus = new RequestStatus(RequestStatus.Status.ERROR, "Episode already exists! :(");
        }
        else {
            savedEpisode = episodeRepository.save(episode);
            requestStatus = new RequestStatus(RequestStatus.Status.SUCCESS, "Insertion success!");
            //updating episode count in anime entity
            Anime anime = animeService.getOne(arc.getAnime().getId());
            anime.setEpisodeCount(anime.getEpisodeCount() + 1);
            animeService.updateAnime(anime);
        }
        return new EpisodeDTO(requestStatus, savedEpisode);*/
        Episode savedEpisode = null;
        Arc arc = arcService.getOne(episode.getArc().getId());
        if ((savedEpisode = episodeRepository.getByEpisodeNumber(episode.getEpisodeNumber())) != null) {
            return ResponseEntity.badRequest()
                    .header("Message", "Episode already exists! :(")
                    .body(new EpisodeDTO(savedEpisode));
        }
        savedEpisode = episodeRepository.save(episode);
        Anime anime = animeService.getOne(arc.getAnime().getId());
        anime.setEpisodeCount(anime.getEpisodeCount() + 1);
        animeService.updateAnime(anime);
        return ResponseEntity.accepted()
                .header("Message","Insertion success! :)")
                .body(new EpisodeDTO(savedEpisode));

    }

    public ResponseEntity<List<EpisodeDTO>> getEpisodesByArc(Arc arc) {
//        return  episodeRepository.findByArcOrderByEpisodeNumber(arc);
        return ResponseEntity.ok()
                .body(EpisodeDTO.getEpisodeDTOList(episodeRepository.findByArcOrderByEpisodeNumber(arc)));

    }

    public void deleteEpisode(String id) {
        episodeRepository.deleteById(id);
    }

}
