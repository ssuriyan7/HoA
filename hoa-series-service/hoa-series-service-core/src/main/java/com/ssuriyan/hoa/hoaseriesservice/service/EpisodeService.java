package com.ssuriyan.hoa.hoaseriesservice.service;

import com.ssuriyan.hoa.hoaseriesservice.dto.EpisodeDTO;
import com.ssuriyan.hoa.hoaseriesservice.dto.RequestStatus;
import com.ssuriyan.hoa.hoaseriesservice.model.Anime;
import com.ssuriyan.hoa.hoaseriesservice.model.Arc;
import com.ssuriyan.hoa.hoaseriesservice.model.Episode;
import com.ssuriyan.hoa.hoaseriesservice.repository.ArcRepository;
import com.ssuriyan.hoa.hoaseriesservice.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EpisodeService {

    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private ArcService arcService;

    public EpisodeDTO insertEpisode(Episode episode) {

        RequestStatus requestStatus;
        Episode savedEpisode = null;
        Arc arc = arcService.getOne(episode.getArc().getId());

        if ((savedEpisode = episodeRepository.getByEpisodeNumber(episode.getEpisodeNumber())) != null) {
            requestStatus = new RequestStatus(RequestStatus.Status.ERROR, "Episode already exists! :(");
        }
        else {
            int arcEpisodeCount = episodeRepository.countByArc_Id(arc.getId());
            if (arcEpisodeCount == 0) {
                arc.setFirstEpisodeOfArc(episode.getEpisodeNumber());
            }
            arc.setLastEpisodeOfArc(episode.getEpisodeNumber());
            savedEpisode = episodeRepository.save(episode);
            arcService.updateArc(arc);
            requestStatus = new RequestStatus(RequestStatus.Status.SUCCESS, "Insertion success!");
        }

        return new EpisodeDTO(requestStatus, savedEpisode);
    }

    public void deleteEpisode(String id) {
        episodeRepository.deleteById(id);
    }

}
