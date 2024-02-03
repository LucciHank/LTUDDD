create database food

use food

create table [Users](
	[UserId] [int] primary key IDENTITY(1,1) not null,
	[Name] [varchar](50) null,
	[Username] [varchar](50) null unique,
	[mobile] [varchar](50) null,
	[Email] [varchar](50) null unique,
	[address] [varchar](max) null,
	[Password] [varchar](50) null,
	[ImageUrl] [varchar](max) null,
)
create table [Contact](
	[ContactId] [int] primary key IDENTITY(1,1) not null,
	[Name] [varchar](50) null,
	[Email] [varchar](50) null,
	[subject] [varchar](200) null,
	[message] [varchar](max) null,
)
create table [categories](
	[CategoriesId] [int] primary key IDENTITY(1,1) not null,
	[Name] [varchar](50) null,
	[ImageUrl] [varchar](max) null,
	[IsActive] [bit] null,
)
create table [products](
	[productId] [int] primary key IDENTITY(1,1) not null,
	[name] [varchar](50) null,
	[Description] [varchar](max) null,
	[price] [decimal](18, 2) null,
	[Quantity] [int] null,
	[imageUrl] [varchar](max) null,
	[category] [int] null, --Fk
	[Isactive] [bit] null,
)
create table [Carts](
	[cartId] [int] primary key IDENTITY(1,1) not null,
	[productId] [int] null, --FK
	[Quantity] [int] null,
	[UserID] [int] null, --FK
)
create table [Orders](
	[OderDetailsId] [int] primary key IDENTITY(1,1) not null,
	[OderNo] [varchar](max) null,
	[productId] [int] null, --FK
	[Quantity] [int] null,
	[userId] [int] null, --FK
	[Status] [varchar](50) null,
	[PaymentId] [int] null, --Fk
	[OrderDate] [datetime] null,
)
create table [payment](
	[paymentId] [int] primary key IDENTITY(1,1) not null,
	[name] [varchar](50) null,
	[Cardno] [varchar](50) null,
	[ExpiryDate] [varchar](50) null,
	[CvvNo] [int] null,
	[address] [varchar](max) null,
	[PaymentMode] [varchar](50) null,
)