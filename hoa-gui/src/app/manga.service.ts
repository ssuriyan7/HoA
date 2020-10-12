import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import {Manga} from './Manga'

@Injectable({
  providedIn: 'root'
})
export class MangaService {

  constructor(private http: HttpClient) { }

  getAllMangas(): Observable<Manga[]> {
    return this.http.get<Manga[]>("http://localhost:8080/manga/all");
  }

  updateManga(manga: Manga): Observable<Manga> {
    return this.http.put<Manga>("http://localhost:8080/manga/update",manga,);
  }
}
