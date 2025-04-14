PGDMP                      }            apiblogmanager_db    17.4    17.4     '           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            (           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            )           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            *           1262    32803    apiblogmanager_db    DATABASE     �   CREATE DATABASE apiblogmanager_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'French_France.1252';
 !   DROP DATABASE apiblogmanager_db;
                     postgres    false            �            1259    32832    article    TABLE     �   CREATE TABLE public.article (
    id bigint NOT NULL,
    content character varying(255),
    publication_date timestamp(6) without time zone,
    title character varying(255)
);
    DROP TABLE public.article;
       public         heap r       postgres    false            �            1259    32831    article_id_seq    SEQUENCE     �   ALTER TABLE public.article ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.article_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public               postgres    false    218            �            1259    32840    comment    TABLE     �   CREATE TABLE public.comment (
    id bigint NOT NULL,
    content character varying(255),
    created_at timestamp(6) without time zone,
    article_id bigint
);
    DROP TABLE public.comment;
       public         heap r       postgres    false            �            1259    32839    comment_id_seq    SEQUENCE     �   ALTER TABLE public.comment ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.comment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public               postgres    false    220            "          0    32832    article 
   TABLE DATA           G   COPY public.article (id, content, publication_date, title) FROM stdin;
    public               postgres    false    218   "       $          0    32840    comment 
   TABLE DATA           F   COPY public.comment (id, content, created_at, article_id) FROM stdin;
    public               postgres    false    220   �       +           0    0    article_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.article_id_seq', 4, true);
          public               postgres    false    217            ,           0    0    comment_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.comment_id_seq', 1, true);
          public               postgres    false    219            �           2606    32838    article article_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.article
    ADD CONSTRAINT article_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.article DROP CONSTRAINT article_pkey;
       public                 postgres    false    218            �           2606    32844    comment comment_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.comment DROP CONSTRAINT comment_pkey;
       public                 postgres    false    220            �           2606    32845 #   comment fk5yx0uphgjc6ik6hb82kkw501y    FK CONSTRAINT     �   ALTER TABLE ONLY public.comment
    ADD CONSTRAINT fk5yx0uphgjc6ik6hb82kkw501y FOREIGN KEY (article_id) REFERENCES public.article(id);
 M   ALTER TABLE ONLY public.comment DROP CONSTRAINT fk5yx0uphgjc6ik6hb82kkw501y;
       public               postgres    false    4748    218    220            "   ~   x�mͱ
�0����)���.�4�&�d� DD���t�D�߂k���`�[ϗF�N V��C��&�I��>X�P�[�6��uA�+eɇN��ƑLs)t;Wt�����SL���P�����V������?J�%�      $   N   x�3�t�HN��I�+Qp,*�L�IUTT�JU��LKSH/J,K�4202�50�54Q04�24�20�373�0��4����� ��     