import { Component, OnInit } from '@angular/core';
import { Manga } from '../Manga';
import { MangaService } from '../manga.service';

@Component({
  selector: 'app-manga',
  templateUrl: './manga.component.html',
  styleUrls: ['./manga.component.css']
})
export class MangaComponent implements OnInit {

  mangas: Manga[];
  constructor(private mangaService: MangaService) { }


  ngOnInit() {
    this.getMangas();
  }

  getMangas(): void {
    this.mangaService.getAllMangas().subscribe(mangas => this.mangas = mangas);
  }

  updateManga(manga: Manga) {
    this.mangaService.updateManga(manga)
        .subscribe(manga => manga);
  }
}
