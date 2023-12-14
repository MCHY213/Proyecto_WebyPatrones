/*Se crea la base de datos */
drop schema if exists keji;
drop user if exists usuario_keji;
CREATE SCHEMA keji;

/*Se crea un usuario para la base de datos llamado "usuario_keji" y tiene la contraseña "Usuario_Keji."*/
create user 'usuario_keji'@'%' identified by 'Usuario_Keji.';

/*Se asignan los prvilegios sobr ela base de datos Keji al usuario creado */
grant all privileges on keji.* to 'usuario_keji'@'%';
flush privileges;

/* la tabla de categoria contiene categorias de productos*/
create table keji.categoria (
  id_categoria INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(30) NOT NULL,
  ruta_imagen varchar(1024),
  activo bool,
  PRIMARY KEY (id_categoria))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

create table keji.producto (
  id_producto INT NOT NULL AUTO_INCREMENT,
  id_categoria INT NOT NULL,
  descripcion VARCHAR(30) NOT NULL,  
  detalle VARCHAR(1600) NOT NULL, 
  precio double,
  existencias int,  
  ruta_imagen varchar(1024),
  activo bool,
  PRIMARY KEY (id_producto),
  foreign key fk_producto_caregoria (id_categoria) references categoria(id_categoria)  
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

/*Se crea la tabla de clientes llamada cliente... igual que la clase Cliente */
CREATE TABLE keji.usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  username varchar(20) NOT NULL,
  password varchar(512) NOT NULL,
  nombre VARCHAR(20) NOT NULL,
  apellidos VARCHAR(30) NOT NULL,
  correo VARCHAR(25) NULL,
  telefono VARCHAR(15) NULL,
  ruta_imagen varchar(1024),
  activo boolean,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

create table keji.factura (
  id_factura INT NOT NULL AUTO_INCREMENT,
  id_usuario INT NOT NULL,
  fecha date,  
  total double,
  estado int,
  PRIMARY KEY (id_factura),
  foreign key fk_factura_usuario (id_usuario) references usuario(id_usuario)  
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

create table keji.venta (
  id_venta INT NOT NULL AUTO_INCREMENT,
  id_factura INT NOT NULL,
  id_producto INT NOT NULL,
  precio double, 
  cantidad int,
  PRIMARY KEY (id_venta),
  foreign key fk_ventas_factura (id_factura) references factura(id_factura),
  foreign key fk_ventas_producto (id_producto) references producto(id_producto) 
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

/*Se insertan 3 registros en la tabla cliente como ejemplo */
INSERT INTO keji.usuario (id_usuario, username,password,nombre, apellidos, correo, telefono,ruta_imagen,activo) VALUES 
(1,'mario','$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.','Mario', 'Chen',    'mario@gmail.com',    '4556-8978', 'https://live.staticflickr.com/3729/9314860865_0e4ec242f7_b.jpg',true),
(2,'jeff','$2a$10$GkEj.ZzmQa/aEfDmtLIh3udIH5fMphx/35d0EYeqZL5uzgCJ0lQRi','Jeff',  'Cordoba', 'jeff@gmail.com', '5456-8789','https://t2.ea.ltmcdn.com/es/razas/9/0/5/rana-arboricola-verde_509_0_600.jpg',true),
(3,'thony','$2a$10$koGR7eS22Pv5KdaVJKDcge04ZB53iMiw76.UjHPY.XyVYlYqXnPbO','Thony', 'Rodriguez',     'thony@gmail.com',      '7898-8936','https://t2.ea.ltmcdn.com/es/razas/9/0/5/rana-arboricola-verde_509_0_600.jpg',true);

/*Se insertan 3 categorias de productos como ejemplo */
INSERT INTO keji.categoria (id_categoria,descripcion,ruta_imagen,activo) VALUES 
('1','Parlantes', 'https://www.unimart.com/cdn/shop/products/Canvasfotosconguias_2_3_1_83_large.jpg?v=1689194557', true), 
('2','Audifonos', 'https://www.cqnetcr.com/108084-large_default/audifonos-apple-airpods-max-bluetooth-inalambrico.jpg', true),
('3','Reparaciones', 'https://www.tuexperto.com/wp-content/uploads/2021/02/xiaomi-redmi-note-8-pro-01-1-1.jpg', true);

/*Se insertan 4 productos por categoria */
INSERT INTO keji.producto (id_producto,id_categoria,descripcion,detalle,precio,existencias,ruta_imagen,activo) VALUES
(1,1,'Parlante Sony MHC-V11', 'Mejor Parlante de Sony', 23000, 5, 'https://www.tupi.com.py//public/f4f276-39550_3.jpg',true),
(2,1,'Parlante Sony SRS-XB12', 'Mejor Parlante de Acompanamiento', 27000,2, 'https://www.unimart.com/cdn/shop/products/Canvasfotosconguias_2_3_1_82_large.jpg?v=1652556397',true),
(3,1,'Parlante Sony Xb41', 'Mejor Parlante de Calidad',24000,5, 'https://i.ebayimg.com/thumbs/images/g/oSQAAOSwyAVk2EHQ/s-l640.jpg',true),
(4,1,'Parlante Bose SoundsLink','Mejor Parlante de Bose',27600,2,'https://www.musicolorcq.com/wp-content/uploads/2022/05/cq5dam.web_.600.600-1.png',true),
(5,2,'Parlate BoseMini 2','Mejor Parlante Mini 2',45000,5,'https://www.paris.cl/dw/image/v2/BCHW_PRD/on/demandware.static/-/Sites-cencosud-master-catalog/default/dw7c9332bd/images/imagenes-productos/702/656503-0000-001.jpg',true),
(6,2,'Airpods 1 Gen','Primer Audifono Inteligente', 57000,2,'https://d1rlzxa98cyc61.cloudfront.net/catalog/product/cache/1801c418208f9607a371e61f8d9184d9/1/7/178904.jpg',true),
(7,2,'Airpods 2 Gen','Segunda Generacion de Airpods', 25000,5,'https://media.croma.com/image/upload/v1674044832/Croma%20Assets/Communication/Headphones%20and%20Earphones/Images/251324_0_c1a675.png',true),
(8,2,'Aipords Pro 1 Gen','Mejor Cancelacion de Sonido',27600,2,'https://media.croma.com/image/upload/v1674044805/Croma%20Assets/Communication/Headphones%20and%20Earphones/Images/251322_0_tpksnj.png',true),
(9,2,'Sony Audifonos','Mejor Calidad de Sonidp',15780,5,'https://www.tiendavargas.com/images/thumbs/0006873_audifonos-sony-wf-c500bz_510.jpeg',true),
(10,2,'Sony Audifonos Marques 5','Mejor Transparecy Mode del Mundo',15000,2,'https://www.radioshackcr.com/4681-large_default/audifonos-sony-wh-1000xm4bm-over-the-head.jpg',true),
(11,2,'Bose 700','Mejor Experiencia Vivida',25400,5,'https://www.icon.co.cr/wp-content/uploads/2020/12/Audifono-Bose-700-bluetooth-negro_1_iCon.jpg',true),
(12,3,'iPhone 15 Pro Max','Mejor Chip de Telefonos',45000,3,'https://avenidatecnologica.com/wp-content/uploads/2023/05/Apple-iPhone-15-Pro-lineup-color-lineup-geo-230912_big.jpg.large_.jpg',true),
(13,3,'iPhone 15','Mejores Colores en un Telefono',285000,4,'https://images.ecestaticos.com/LqLdwn_Py7Ie90v09FaG1np6WSE=/120x0:983x647/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F702%2F227%2F817%2F702227817072f5f19511f9a908fa74b3.jpg',true),
(14,3,'Xiaomi Redmi Note 8 Pro','Mejor Camara de Telefono',154000,5,'https://img.gkbcdn.com/p/2019-08-29/xiaomi-redmi-note-8-pro-6-53-inch-8gb-128gb-green-1574132598513._w500_p1_.jpg',true),
(15,3,'Xiaomi Redmi Note 9 Pro','Mejor Resolucion de Pantalla',330000,2,'https://ss632.liverpool.com.mx/xl/1114878461.jpg',true),
(16,3,'Xiaomi x45','Mejor Resoluicion',273000,1,'https://www.trustedreviews.com/wp-content/uploads/sites/54/2022/03/20220315_104812-1-scaled.jpg',true);

/*Se crean 6 facturas */   /*'Activa','Pagada','Anulada')*/
INSERT INTO keji.factura (id_factura,id_usuario,fecha,total,estado) VALUES
(1,1,'2022-01-05',211560,2),
(2,2,'2022-01-07',554340,2),
(3,3,'2022-01-20',871000,2),
(4,1,'2023-01-01',244140,1),
(5,2,'2023-01-17',414800,1),
(6,3,'2023-01-30',420000,1);

INSERT INTO keji.venta (id_venta,id_factura,id_producto,precio,cantidad) values
(1,1,5,45000,3),
(2,1,9,15780,2),
(3,1,10,15000,3),
(4,2,5,45000,1),
(5,2,14,154000,3),
(6,2,9,15780,3),
(7,3,14,154000,1),
(8,3,6,57000,1),
(9,3,15,330000,2),
(10,1,6,57000,2),
(11,1,8,27600,3),
(12,1,9,15780,3),
(13,2,8,27600,3),
(14,2,14,154000,2),
(15,2,3,24000,1),
(16,3,15,330000,1),
(17,3,12,45000,1),
(18,3,10,15000,3);

create table keji.rol (
  id_rol INT NOT NULL AUTO_INCREMENT,
  nombre varchar(20),
  id_usuario int,
  PRIMARY KEY (id_rol),
  foreign key fk_rol_usuario (id_usuario) references usuario(id_usuario)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

insert into keji.rol (id_rol, nombre, id_usuario) values
 (1,'ROLE_ADMIN',1), (2,'ROLE_VENDEDOR',1), (3,'ROLE_USER',1),
 (4,'ROLE_VENDEDOR',2), (5,'ROLE_USER',2),
 (6,'ROLE_USER',3);