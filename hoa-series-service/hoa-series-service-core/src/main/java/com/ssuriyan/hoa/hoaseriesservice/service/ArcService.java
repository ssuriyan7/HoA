package com.ssuriyan.hoa.hoaseriesservice.service;


import com.ssuriyan.hoa.hoaseriesservice.dto.ArcDTO;
import com.ssuriyan.hoa.hoaseriesservice.dto.RequestStatus;
import com.ssuriyan.hoa.hoaseriesservice.model.Anime;
import com.ssuriyan.hoa.hoaseriesservice.model.Arc;
import com.ssuriyan.hoa.hoaseriesservice.repository.ArcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ArcService {

    @Autowired
    private ArcRepository arcRepository;

    @Autowired
    private AnimeService animeService;

    public ArcDTO insertArc(Arc arc) {
        RequestStatus requestStatus;
        Arc savedArc = null;
//        ArcDTO arcDTO = new ArcDTO();
        /*Arc tempArc = arcRepository.getArcByArcNumber(arc.getArcNumber());
        if (tempArc != null) {
            requestStatus = new RequestStatus(RequestStatus.Status.ERROR,"Arc " + tempArc.getArcNumber() + " already exists! :(");
        } else {
            arc.setFirstEpisodeOfArc(0);
            arc.setLastEpisodeOfArc(0);
            tempArc = arcRepository.save(arc);
            requestStatus = new RequestStatus(RequestStatus.Status.SUCCESS, "Insertion Success! :)");
        }
        arcDTO.setRequestStatus(requestStatus);
        arcDTO.setArcToDTO(tempArc);*/
        /*Arc tempArc = arcRepository.save(arc);
        if(tempArc == null) {
            requestStatus = new RequestStatus(RequestStatus.Status.ERROR,"Arc " + tempArc.getArcNumber() + " already exists! :(");
        } else {
            arc.setFirstEpisodeOfArc(0);
            arc.setLastEpisodeOfArc(0);
            requestStatus = new RequestStatus(RequestStatus.Status.SUCCESS, "Insertion Success! :)");
        }
        arcDTO.setRequestStatus(requestStatus);
        arcDTO.setArcToDTO(tempArc);*/
        if ((savedArc = arcRepository.getByArcNumber(arc.getArcNumber())) != null) {
            requestStatus = new RequestStatus(RequestStatus.Status.ERROR,"Arc already exists! :(");
        } else {
            savedArc = arcRepository.save(arc);
            requestStatus = new RequestStatus(RequestStatus.Status.SUCCESS, "Insertion Success! :)");
        }
        return new ArcDTO(requestStatus, savedArc);
    }

    public Arc updateArc(Arc arc) {
        return  arcRepository.save(arc);
    }

    public Arc getOne(String arcId) {
        return arcRepository.getOne(arcId);
    }

    public void deleteArc(String id) {
        arcRepository.deleteById(id);
    }

    public void deleteArcByAnime(Anime anime) {
        arcRepository.deleteByAnime(anime);
    }
}